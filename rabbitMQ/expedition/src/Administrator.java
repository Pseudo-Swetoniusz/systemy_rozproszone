import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeoutException;

public class Administrator {
    ConnectionFactory factory;
    Connection connection;
    Channel channel;
    String queueName;
    private static final String EXCHANGE_NAME = "expedition";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void createAdministrator() throws IOException, TimeoutException {
        System.out.println("ADMNISTRATOR");
        System.out.println("-------------------------------------");

        this.factory = new ConnectionFactory();
        this.factory.setHost("localhost");
        this.connection = factory.newConnection();
        this.channel = connection.createChannel();
        this.channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        this.channel.basicQos(1);
        this.queueName = "admin";
        this.channel.queueDeclare(this.queueName, false, false, false, null);
        String key = "expedition.#";
        this.channel.queueBind(this.queueName,EXCHANGE_NAME,key);
        this.channel.basicQos(1);

        System.out.println("New administrator was added");
        System.out.println("-------------------------------------");
    }

    public void startAdministratorConsumer() throws IOException {
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("[RECEIVED] " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        this.channel.basicConsume(this.queueName, false, consumer);
    }

    public void startAdministrator() throws IOException {
        while(true) {
            String message = br.readLine();
            if(message.contains("#")) {
                String[] result = message.split("#");
                if(result[0].equals("AT")) {
                    String routingKey = "expedition.team";
                    channel.basicPublish(EXCHANGE_NAME, routingKey, null, result[1].getBytes("UTF-8"));
                }
                else if(result[0].equals("AS")) {
                    String routingKey = "expedition.supplier";
                    channel.basicPublish(EXCHANGE_NAME, routingKey, null, result[1].getBytes("UTF-8"));
                }
                else if(result[0].equals("A")) {
                    String routingKey = "expedition";
                    channel.basicPublish(EXCHANGE_NAME, routingKey, null, result[1].getBytes("UTF-8"));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Administrator a = new Administrator();
        a.createAdministrator();
        a.startAdministratorConsumer();
        a.startAdministrator();
    }
}
