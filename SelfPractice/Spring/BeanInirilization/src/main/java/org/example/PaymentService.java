package org.example;

import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Lazy()
public class PaymentService {

    OrderService orderService;
    public PaymentService(OrderService orderService){
        this.orderService =orderService;
        System.out.println(" Payment bean created");
    }
    public void pay(){
        System.out.println("payment done");
    }
}
