import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class Supplier {
    ConnectionFactory factory;
    Connection connection;
    Channel channel;
    private static final String EXCHANGE_NAME = "expedition";
    String name;
    String queue;
    int number_of_orders = 0;
    ArrayList<String> availableProducts = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void createSupplier() throws IOException, TimeoutException {
        System.out.println("NEW SUPPLIER");
        System.out.println("-------------------------------------");
        System.out.println("Enter supplier's name:");
        this.name = br.readLine();
        System.out.println("SUPPLIER'S NAME: " + this.name);
        boolean read = false;
        int n = 0;
        while(!read) {
            System.out.println("Enter number of products:");
            String in = br.readLine();
            try {
                n = Integer.parseInt(in);
                read = true;
            }catch(NumberFormatException e) {
                System.out.println("ERROR");
            }
        }
        System.out.println("Enter " + n + " products:");
        for(int i=0; i<n; i++) {
            String product = br.readLine();
            availableProducts.add(product);
        }
        System.out.println("PRODUCT LIST:");
        for(String p: availableProducts) {
            System.out.println(p);
        }

        this.factory = new ConnectionFactory();
        this.factory.setHost("localhost");
        this.connection = factory.newConnection();
        this.channel = connection.createChannel();
        this.channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        this.queue = "supplier_queue_" + this.name;
        this.channel.basicQos(1);

        System.out.println("New supplier was added");
        System.out.println("-------------------------------------");
    }

    public void startSupplier() throws IOException {
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                channel.basicAck(envelope.getDeliveryTag(), false);
                if(message.contains("#")) {
                    String[] result = message.split("#");
                    number_of_orders++;
                    System.out.println("[ORDER] /order nr " + number_of_orders + "/ new order from " + result[0] + ", product:" + result[1]);
                    String routingKey = "expedition.team." + result[0];
                    String back = "order accepted: " + result[0] + ", product:" + result[1];
                    channel.basicPublish(EXCHANGE_NAME, routingKey, null, back.getBytes("UTF-8"));
                    System.out.println("[ACCEPTED] /order nr " + number_of_orders + "/ order: " + result[0] + ", " + result[1]);
                }
                else {
                    System.out.println("[RECEIVED] " + message);
                }
            }
        };

        String key1 = "expedition";
        String key2 = "expedition.supplier";
        this.channel.queueDeclare(queue, false, false, false, null);
        this.channel.queueBind(queue,EXCHANGE_NAME,key1);
        this.channel.queueBind(queue,EXCHANGE_NAME,key2);
        this.channel.basicConsume(queue, false, consumer);

        for(String p: availableProducts) {
            String key = "expedition." + p;
            String queueName = "product_queue_" + p;
            this.channel.queueDeclare(queueName, false, false, false, null);
            this.channel.queueBind(queueName,EXCHANGE_NAME,key);
            this.channel.basicConsume(queueName, false, consumer);
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Supplier s = new Supplier();
        s.createSupplier();
        s.startSupplier();
    }
}
