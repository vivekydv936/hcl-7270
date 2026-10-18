package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {


    // both will create two different objects in contanier
    @Bean
    public OrderService createOrderObj(){
        return new OrderService();
    }

    @Bean
    public OrderService createOrderObj2(){
        return new OrderService();
    }
}
