package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
//@Autowired
//    OrderServics orderServics;

//    PaymentService(OrderServics orderServics){
//        this.orderServics =orderServics;
//    }

    public void pay(){
        System.out.println("payment done");
        // not its responsibility
        // orderServics.getOrderDetails();
    }
}
