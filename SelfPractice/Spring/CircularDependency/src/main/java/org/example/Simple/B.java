package org.example.Simple;

public class B {       // neeed manual obj/beann creatioin
    A a;
    public B(){
        System.out.println("b created");
        this.a =new A();
    }
}
