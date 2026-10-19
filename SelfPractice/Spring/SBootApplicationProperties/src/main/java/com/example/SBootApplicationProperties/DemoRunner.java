package com.example.SBootApplicationProperties;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner/*ApplicationRunner*/ {
     private PaymentGateway paymentGateway;

     DemoRunner(PaymentGateway paymentGateway){
         this.paymentGateway = paymentGateway;
     }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        paymentGateway.display();
//    }

    @Override
    public void run(String... args) throws Exception {
        paymentGateway.display();
    }
}
