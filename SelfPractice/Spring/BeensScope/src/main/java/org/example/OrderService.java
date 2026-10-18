package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
public class OrderService {



    public OrderService (){

        System.out.println(" order service obj created");
    }



    public void orderPlaced(){

        System.out.println("order placed");
    }
}
