package customer;

import com.google.gson.Gson;
import customer.dto.Offer;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.util.jndi.JndiContext;

public class CamelRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        MessageToBooking myBooking = new MessageToBooking();
        JndiContext jndiContext = new JndiContext();
        jndiContext.bind("sendBooking", myBooking);
        String url = "rabbitmq:localhost:5672/travelagency?username=guest&password=guest&autoDelete=false&routingKey=camel&queue=USA";
//        Gson gson = new Gson();
        from(url).unmarshal().json(JsonLibrary.Gson).log("${body}");
//        from(url).log("the message is ${body}");
//        gson.fromJson("${body}",Offer.class)));
//        Offer offer = ;
//        System.out.println(offer.toString());
/*        from(url).log("the original message is ${body}")
                .log("Transformed message is ${body}")
                .from("stream:in?promptMessage=Enter message:")
                .choice()
                .when(bodyAs(String.class).contains("YES"))
//                .bean(myBooking,"sendYesMessage")
                .setHeader("name", simple("John"))
                .setHeader("email", simple("test@mail.com"))
                .setHeader("offerId", simple("test@mail.com"))
                .to("bean:myBean?method=beanMethod(${header.someHeader})")
                .when(bodyAs(String.class).contains("PASS")).end();
    }*/
    }
}
