package customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class MainCustomer {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainCustomer.class);
        app.setDefaultProperties(Collections.singletonMap("server.port","8082"));
        app.run();
        try {
            Receiver.receive("USA");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
