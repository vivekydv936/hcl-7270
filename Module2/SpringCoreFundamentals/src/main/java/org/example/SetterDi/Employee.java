package org.example.SetterDi;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private Address address;

    public void setAddress(Address address) {

        this.address = address;
    }

    public void displayAddress(){

        System.out.println(address.getAddress());
    }



}
