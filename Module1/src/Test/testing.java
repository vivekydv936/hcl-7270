package Test;
import Student.*;
class p extends Work{
        void extended_method(){
            System.out.println("Ectended ");
        }
}

public class testing extends p {
    public static void main(String[] args) {
        testing t= new testing();
        t.protected_method();
    }
}
