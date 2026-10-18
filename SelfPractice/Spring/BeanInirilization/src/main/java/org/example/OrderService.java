package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class OrderService {
  PaymentService paymentService;


   public OrderService(  @Lazy PaymentService paymentService){   // for order service payment dependency is needed ,
       // but using lazy it provides a proxy dependency to order service and don't create obj of payment --> created and wire a object when any method of Payment is called
       // using @lazy we solve circular dependency
       this.paymentService =paymentService;
        System.out.println(" order bean created");
    }

    public void Placeorder(){
       paymentService.pay();
        System.out.println("order placed");

        orderdetails();
    }

    public void orderdetails(){
        System.out.println("order details");
    }

}
