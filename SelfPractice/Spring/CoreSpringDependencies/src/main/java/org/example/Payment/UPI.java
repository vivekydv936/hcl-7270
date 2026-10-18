package org.example.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier

public class UPI implements Payments {
    @Override
    public void pay(){
        System.out.println("pay via UPI");
    }
}
