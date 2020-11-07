package offers;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Config {


    public final static String QUEUE_NAME = "myrabbitqueue";
    public final static String EXCHANGE_NAME = "travelagency";
    public final static String BINDING_KEY = "camel";

    public static void configConnection(String message, String queue) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        // try-with-resources (closes used resources without finally)
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // declare a direct, durable exchange
            channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);

            // declare a durable, non exclusive, non auto-delete queue
            channel.queueDeclare(queue, true, false, false, null);

            // bind the queue to the exchange with the routing key 'camel'
            channel.queueBind(queue, EXCHANGE_NAME, BINDING_KEY);
            channel.basicPublish(EXCHANGE_NAME, BINDING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
        }
    }
}
