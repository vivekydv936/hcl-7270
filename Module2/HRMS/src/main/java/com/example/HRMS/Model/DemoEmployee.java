package com.example.HRMS.Model;

import com.example.HRMS.Repository.EmpREimp;
import com.example.HRMS.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoEmployee {
    @Autowired
    private EmpREimp empREimp;

    public int add(){

       return empREimp.add(12,15);

    }

    public double squareRoot(){
       return empREimp.Squareroot(200);
    }
}
