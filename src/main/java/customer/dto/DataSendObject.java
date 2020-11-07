package customer.dto;

public class DataSendObject {
    public String name;
    public String email;
    public Long offerId;

    public DataSendObject(String name, String email, Long offerId) {
        this.name = name;
        this.email = email;
        this.offerId = offerId;
    }
}
