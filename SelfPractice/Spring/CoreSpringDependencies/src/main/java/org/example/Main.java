package org.example;

import org.example.Notifications.EmailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
//            PaymentService payment =new PaymentService();
//            OrderService os = new OrderService(payment);
//            os.order();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order =context.getBean(OrderService.class);
        order.placeorder();


//        User u =context.getBean(User.class);
//        System.out.println( u.getAge());

//        EmailService email =context.getBean(EmailService.class);
//        email.SendNotification();



//        EmailService email = new EmailService();   //  Used from my other jar file
//        email.SendNotification();






    }
}
