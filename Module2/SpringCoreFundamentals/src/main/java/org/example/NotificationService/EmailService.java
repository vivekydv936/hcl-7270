package org.example.NotificationService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier
@Primary
public class EmailService implements NotificationService{

    @Override
    public void sendMsg(String msg) {
        System.out.println("Email "+msg);
    }
}
