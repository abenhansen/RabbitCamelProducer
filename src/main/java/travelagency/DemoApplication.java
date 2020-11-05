package travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
/*        String message  = "Hello World";
        try{
            //Why are you creating this, when this is a static method???
            //RabbitConfig rabbitConfig = new RabbitConfig();
            RabbitConfig.configConnection(message,"USA");
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
        SpringApplication.run(DemoApplication.class, args);
    }

}
