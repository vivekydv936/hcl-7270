package org.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
     static void main() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        OrderService order = context.getBean(OrderService.class);
//        order.placeOrder();

//        UserService userService = context.getBean(UserService.class);
//        userService.setBeanName("userBean2");

        CartService cart = context.getBean(CartService.class);
        System.out.println(cart.getValue(1));

        context.close();

         System.out.println(cart.getValue(1));
    }
}