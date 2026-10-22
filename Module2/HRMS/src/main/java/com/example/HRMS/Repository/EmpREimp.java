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
    public int add(int a, int b) {
        return a+b;
    }




}
