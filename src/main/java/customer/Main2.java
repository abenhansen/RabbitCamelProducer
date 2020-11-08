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
            JsonObject jobj = new Gson().fromJson(message, JsonObject.class);
            Long id = jobj.get("id").getAsLong();
            Double price = jobj.get("price").getAsDouble();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            try {
                date  = formatter.parse(jobj.get("date").getAsString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String destination = jobj.get("destination").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
