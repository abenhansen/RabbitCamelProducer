package travelagency;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import travelagency.datalayer.OfferRepository;
import travelagency.entities.Offer;

import java.util.Date;

public class SendOffersAndPersist {
    private OfferRepository repo;

    public SendOffersAndPersist(OfferRepository repo){
        this.repo = repo;
    }

    public void SendOffer(){
        Offer offer1 = new Offer("USA",200, new Date());
        Offer offer2 = new Offer("CHINA",500, new Date());
        Offer offer3 = new Offer("INDIA",400, new Date());
        offer1 = repo.save(offer1);
        System.out.println("id is " + offer1.getId());


        Gson gson = new Gson();
        try{
            Config.configConnection(gson.toJson(offer1),offer1.getDestination());
            Config.configConnection(gson.toJson(offer2),offer2.getDestination());
            Config.configConnection(gson.toJson(offer3),offer3.getDestination());
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
