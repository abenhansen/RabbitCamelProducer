package travelagency.offers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import travelagency.DemoApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        String message  = "Hello World";
        try{
            //Why are you creating this, when this is a static method???
            //RabbitConfig rabbitConfig = new Config();
            Config.configConnection(message,"USA");
            Config.configConnection(message,"CHINA");
            Config.configConnection(message,"INDIA");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        SpringApplication.run(DemoApplication.class, args);
    }

}
