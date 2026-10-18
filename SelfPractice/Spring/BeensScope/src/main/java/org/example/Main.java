package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
     static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order1 = context.getBean("createOrderObj2",OrderService.class);   // in container only create single bean -->not multiple beans are created --> folllows singelton
//        OrderService order2 = context.getBean(OrderService.class);
//
//         System.out.println(order1.equals(order2));
         order1.orderPlaced();
    }
}
