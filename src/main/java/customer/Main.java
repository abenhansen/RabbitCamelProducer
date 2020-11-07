package customer;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        CamelContext myContext = new DefaultCamelContext();
        CamelRoute myRoute = new CamelRoute();

        try {
            myContext.addRoutes(myRoute);
            myContext.start();
            Endpoint endpoint  = myContext.getEndpoint("rabbitmq://localhost:5672/travelagency?username=guest&password=guest&autoDelete=false&routingKey=camel&queue=USA");
            Thread.sleep(5000);
//            myContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SpringApplication.run(Main.class, args);
    }

}
