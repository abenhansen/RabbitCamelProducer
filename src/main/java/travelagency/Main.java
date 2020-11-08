package travelagency;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import travelagency.datalayer.OfferRepository;
import travelagency.entities.Offer;

import java.util.Date;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        //TODO: make console program that can accept below as input
       SendOffersAndPersist sendOffers = new SendOffersAndPersist();
       sendOffers.SendOffer();

    }

}
