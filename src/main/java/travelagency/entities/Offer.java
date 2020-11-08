package travelagency.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String date;
    private String destination;

    public Offer(){

    }
    public Offer(String destination, double price, String date) {
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

    public String getDate() {
        return date;
    }
}
