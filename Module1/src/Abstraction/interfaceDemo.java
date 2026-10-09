
package Abstraction;

interface Payment {
    void pay(double amount);
}
interface temperory{
    void test();
}

class UPI implements Payment,temperory {
    @Override 
    public void test(){
        System.out.println("test funvtion of temporary interface");
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CreditCard implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

public class interfaceDemo {

    public static void main(String[] args) {

        Payment p1 = new UPI();
        p1.pay(500);
        
        // temperory t1= new UPI() ;
        // t1.test();

        // UPI u1 = new UPI();
        // u1.test();


        Payment p2 = new CreditCard();
        p2.pay(1000);
            CreditCard c1 =new CreditCard();
            c1.pay(0);
        
    }
}
