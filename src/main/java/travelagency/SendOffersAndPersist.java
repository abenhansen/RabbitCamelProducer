package travelagency;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import travelagency.datalayer.OfferRepository;
import travelagency.entities.Offer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

@Component
public class SendOffersAndPersist {

    private static OfferRepository repo;

    //TODO: This is how to use spring boot depedency injection in static classes!!!
    @Autowired
    public SendOffersAndPersist(OfferRepository repo){
        this.repo = repo;
    }


    public static void SendOffer() throws ParseException {
        Offer offer1 = new Offer("USA",35, LocalDate.of(2020, 10,10).toString());
        offer1 = repo.save(offer1);
        System.out.println("id is " + offer1.getId());
        Gson gson = new Gson();
        try{
            String json = gson.toJson(offer1);
            System.out.println(json);
            Config.configConnection(json,offer1.getDestination());
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
