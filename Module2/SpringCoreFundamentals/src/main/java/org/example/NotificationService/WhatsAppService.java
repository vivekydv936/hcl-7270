package org.example.NotificationService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier
public class WhatsAppService implements NotificationService{
    @Override
    public void sendMsg(String msg) {

        System.out.println("WhatsApp "+msg);
    }
}
