package travelagency.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private Date date;
    private String destination;

    public Offer(){

    }
    public Offer(String destination, double price, Date date) {
        this.destination = destination;
        this.id = id;
        this.price = price;
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}
