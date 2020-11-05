package offers;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import travelagency.DemoApplication;
import travelagency.entities.Offer;

import java.util.Date;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        String message  = "Hello World";
        Offer offer1 = new Offer("USA",200, new Date());
        Offer offer2 = new Offer("CHINA",500, new Date());
        Offer offer3 = new Offer("INDIA",400, new Date());
        Gson gson = new Gson();
        try{
            Config.configConnection(gson.toJson(offer1),offer1.getDestination());
            Config.configConnection(gson.toJson(offer2),offer2.getDestination());
            Config.configConnection(gson.toJson(offer3),offer3.getDestination());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        SpringApplication.run(DemoApplication.class, args);
    }

}
