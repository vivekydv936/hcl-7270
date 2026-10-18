package org.example.Notifications;

public class SmsService implements NotificationService {
    @Override
    public void SendNotification(){
        System.out.println("SMS notification sent");
    }
}
