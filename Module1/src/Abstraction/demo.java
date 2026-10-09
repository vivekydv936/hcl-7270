
package Abstraction;

abstract class a {
    public abstract void show();
}

class b extends a {
    @Override
    public void show() {
        System.out.println("Show method implemented");
    }
}

public class demo {
    public static void main(String[] args) {
        b obj = new b();
        obj.show();  
    }
}

