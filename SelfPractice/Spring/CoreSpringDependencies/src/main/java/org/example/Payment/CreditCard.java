package org.example.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
@Qualifier("CC")
public class CreditCard implements Payments{
    public void pay(){
        System.out.println("pay via credit card");
    }
}
