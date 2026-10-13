package Comparable;

import java.util.*;

class mycomparable implements Comparable<mycomparable>{
    int roll;
    int age;
    String name;
    mycomparable(int roll,int age,String name){
        this.age=age;
        this.name=name;
        this.roll =roll;

    }
    @Override 
    public int compareTo(mycomparable other){
        return Integer.compare(this.age,other.age);
    }



}



public class demo {
    public static void main(String[] args) {
        
       

    }
    
}
