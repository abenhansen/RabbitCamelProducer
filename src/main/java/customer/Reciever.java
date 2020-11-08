package customer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Reciever {
    public static String Recieve(String queue) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(queue, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            String message = new String(delivery.getBody(), "UTF-8");
            handleMessage(message);
        };
        return channel.basicConsume(queue, true, deliverCallback, consumerTag -> { });
    }

    private static void handleMessage(String message){
        JsonObject jobj = new Gson().fromJson(message, JsonObject.class);
        System.out.println(jobj);
        Long id = jobj.get("id").getAsLong();
        Double price = jobj.get("price").getAsDouble();
        String destination = jobj.get("destination").getAsString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date  = formatter.parse(jobj.get("date").getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Offer recieved: Destination " + destination + ", price: " + price + ", date: " + date);
        System.out.println("Accept or pass?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if(answer.equals("pass")){

        }else{
            //TODO : produce new rabbitmq message
        }
    }
}
