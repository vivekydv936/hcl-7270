package org.example;

import org.example.Payment.Payments;
import org.example.Payment.UPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {
//     @Autowired // 1: field inj is not suitable for testing --> intesting we need to create manual constructor
    // can also cause null pointer exception
        Payments paymentService ;


         @Autowired   // 1 constructor inj
        public OrderService( Payments paymentService){
            this.paymentService =paymentService;

        }

      //  2: setter injection
//    @Autowired
//    public void setPaymentService(Payments paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeorder(){
            System.out.println("order placed");
            paymentService.pay();
        }



}
