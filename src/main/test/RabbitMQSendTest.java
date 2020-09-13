import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * description
 *
 * @author jamin
 * @date 2020/9/6
 */
public class RabbitMQSendTest {

    private final static String QUEUE_NAME = "queue-demo-client";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("103.40.29.133");
        factory.setUsername("admin");
        factory.setPassword("i4S5ESRQauYL1rrH");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Send '" + message + "'");

        channel.close();
        connection.close();
    }
}
