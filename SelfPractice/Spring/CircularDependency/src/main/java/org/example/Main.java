package org.example;

import org.example.Simple.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;


public class Main {
    static void main() {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        OrderServics order =context.getBean(OrderServics.class);
        order.placeorder();

//            A a =new A();


    }
}
