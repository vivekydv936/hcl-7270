package com.example.HRMS.Model;

import com.example.HRMS.Repository.EmpREimp;
import com.example.HRMS.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoEmployee {
    @Autowired
    private EmpREimp empREimp;

    public int add(int num1,int num2){

       return empREimp.add(num1,num2);

    }

    public double squareRoot(){
       return empREimp.Squareroot(200);
    }

    public int greater(int num1,int num2){
        int max =empREimp.greater(num1,num2);
        return max;
    }
}
