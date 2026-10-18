package org.example.Notifications;

public class EmailService implements NotificationService {
    @Override
    public void SendNotification(){
        System.out.println("Email notification sent");
    }


}
