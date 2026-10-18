package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServics {
    @Autowired
    PaymentService paymentService;


    // creating circular dependency because of constructor injection ,--. at time of creation og bean it requires other obj
    // to avoid we can use setter and field injection

//    OrderServics(PaymentService paymentService){
//        this.paymentService =paymentService;
//    }
        public void placeorder(){
        paymentService.pay();
            System.out.println("order placed");
            getOrderDetails();
        }
        public void getOrderDetails(){
            System.out.println("order details");
        }
}
