package constructor;
import oops.*;

public class demo {
    int rolllno;
    String name;
    demo(int rolllno,String name ){
        System.out.println("this is paratermatrized");
            this.rolllno =rolllno;
            this.name =name;
    }
    demo(){
            System.out.println("this is default");
    }
    public static void main(String[] args) {
        // demo d =new demo();
        //  System.out.println(d.name);
       demo d1 = new demo(20,"vivek");
       
        // System.out.println(d1.name);

    }
}
