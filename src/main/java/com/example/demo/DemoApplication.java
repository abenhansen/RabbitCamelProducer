package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        String message  = args[0];
        try{
            //Why are you creating this, when this is a static method???
            //RabbitConfig rabbitConfig = new RabbitConfig();
            RabbitConfig.configConnection(message);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        SpringApplication.run(DemoApplication.class, args);
    }

}
