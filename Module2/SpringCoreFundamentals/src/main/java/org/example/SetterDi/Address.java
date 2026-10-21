package org.example.SetterDi;

import org.springframework.stereotype.Component;

@Component
public class Address {
   // String address;

//    public Address(String address) {
//        this.address = address;
//    }

    public String getAddress(){

        return "abes engineering Setter di";
    }

}
