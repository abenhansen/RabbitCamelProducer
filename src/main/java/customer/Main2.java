package customer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class Main2 {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main2.class);
        app.setDefaultProperties(Collections.singletonMap("server.port","8082"));
        app.run();
        try {
            String message = Reciever.Recieve("USA");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
