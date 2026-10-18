package org.example;

import org.example.Notifications.EmailService;
import org.example.Notifications.NotificationService;
import org.example.Notifications.pop_upService;

public class Main {
    static void main() {
        // System.out.println(" main functin entry point");
        NotificationService notification = new EmailService();

//       OrderService order = new OrderService(notification);   // injecting via constructor

        OrderService order = new OrderService();    // injecting via setter method
        order.setNotification(notification);
       order.placeOrder();
    }
}


// class should ask what it need , not build it inself
