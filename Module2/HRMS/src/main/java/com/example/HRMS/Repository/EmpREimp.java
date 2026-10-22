package com.example.HRMS.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class EmpREimp implements EmpRepo {

    @Override
    public double Squareroot(double d) {
        double result =Math.sqrt(d);
        return result;
    }

    @Override
    public String empData(){

        return "";
    }

    @Override
    public int add(int num1, int num2) {
        return num1+num2;
    }

    @Override
    public int greater(int num1, int num2) {
        return Math.max(num1,num2);
    }


}
