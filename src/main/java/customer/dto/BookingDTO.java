package customer.dto;

public class BookingDTO {
    public String name;
    public String email;
    public Long offerId;

    public BookingDTO(String name, String email, Long offerId) {
        this.name = name;
        this.email = email;
        this.offerId = offerId;
    }
}
