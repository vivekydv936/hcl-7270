package org.example.NotificationService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Autowired
    private  NotificationService notificationService;

    public Student(NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    public void notifyStudent(){
        notificationService.sendMsg("your assessment is scheduled");

    }
    @PostConstruct
    public void init(){
        System.out.println("OBject created");
    }

    @PreDestroy

    public  void Destroy(){
        System.out.println("object destroyed");
    }

}
