package travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws ParseException {
      SpringApplication.run(Main.class, args);
        //TODO: make console program that can accept below as input
       SendOffersAndPersist.SendOffer();

    }

}
