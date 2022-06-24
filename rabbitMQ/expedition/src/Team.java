import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

public class Team {
    ConnectionFactory factory;
    Connection connection;
    Channel channel;
    private static final String EXCHANGE_NAME = "expedition";
    String name;
    String queueName;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> availableProducts = new ArrayList<>(Arrays.asList("buty", "plecak", "tlen"));


    public void createTeam() throws IOException, TimeoutException {
        System.out.println("NEW TEAM");
        System.out.println("-------------------------------------");
        System.out.println("Enter team's name:");
        this.name = br.readLine();
        System.out.println("TEAM'S NAME: " + this.name);

        this.factory = new ConnectionFactory();
        this.factory.setHost("localhost");
        this.connection = factory.newConnection();
        this.channel = connection.createChannel();
        this.channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        this.queueName = "team_queue_" + this.name;
        this.channel.queueDeclare(this.queueName, false, false, false, null);
        String key = "expedition.team." + this.name;
        String key2 = "expedition.team";
        String key3 = "expedition";
        this.channel.queueBind(this.queueName,EXCHANGE_NAME,key);
        this.channel.queueBind(this.queueName,EXCHANGE_NAME,key2);
        this.channel.queueBind(this.queueName,EXCHANGE_NAME,key3);
        this.channel.basicQos(1);

        System.out.println("New team was added");
        System.out.println("-------------------------------------");
    }

    public void startConsumer() throws IOException {
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

    public void startTeam() throws IOException {
        while(true) {
            String product = br.readLine();
            if(availableProducts.contains(product)){
                String routingKey = "expedition." + product;
                String message = this.name + "#" + product;
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
                System.out.println("[SENT] new order: " + product);
            }
            else {
                System.out.println("This product is unavailable");
            }
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Team t = new Team();
        t.createTeam();
        t.startConsumer();
        t.startTeam();
    }
}
