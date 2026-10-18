package org.example;

import org.example.Notifications.EmailService;
import org.example.Payment.CreditCard;
import org.example.Payment.Payments;
import org.example.Payment.UPI;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public User createUser(){
        return new User(23,"vivek");
    }

    @Bean
    public EmailService CreateEmail(){
        return new EmailService();
    }

    @Bean
    @Qualifier
    public Payments CreateUPI(){
        return new UPI();
    }
    @Bean
//    @Primary
    @Qualifier("CC")
    public Payments CreateCreditCard(){
        return new CreditCard();
    }

 //dependency injection via constructor
    @Bean
    public OrderService createOrderService(@Qualifier("CreateCreditCard") Payments paymentService){
        return new OrderService(paymentService);
    }


    // using setter
//    @Bean
//    public OrderService CreateOrder(){
//        return new OrderService();    // bean created but manually wired automatically
//    }

}
