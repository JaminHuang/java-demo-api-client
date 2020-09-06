import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * description
 *
 * @author jamin
 * @date 2020/9/6
 */
public class RabbitMQRevTest {

    private final static String QUEUE_NAME = "queue-demo-client";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("103.40.29.133");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("/");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }
    }
}
