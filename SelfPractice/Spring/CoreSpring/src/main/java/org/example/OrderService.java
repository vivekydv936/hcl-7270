package org.example;

import org.example.Notifications.EmailService;
import org.example.Notifications.NotificationService;

import javax.management.Notification;

public class OrderService {
    // 1:order dependency on Notification
    // 2: breaking solid rule ,order service should only manage order , should not create notification obj
    // 3: don't create dependency by self,this make tightly coupled application
    // 4: single responsibility --> single class have single responsibility
    //5: shuould be like get notification from somewhere and only use in order


    //Dependency Injection --> dont ceate dependency get ur dependecny
    // 2 types --> via constructor __> via setter method
    NotificationService notification ;

     //not creating obj by self,--> recieving already created obj via constructor

      //    OrderService(NotificationService notification){
      //        this.notification =notification;
      //    }



    // via setter
    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }

    public void placeOrder(){
            System.out.println("order placed");
            notification.SendNotification();
        }
}
