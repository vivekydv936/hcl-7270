package superKeyword;
class Parent {

    Parent() {
        System.out.println("Parent default constructor");
    }

    Parent(int x) {
        System.out.println("Parent parameterized constructor: " + x);
    }
}

class Child extends Parent {

    Child() {
        this(100);  // calls another constructor of SAME class
        System.out.println("Child default constructor");
    }

    Child(int x) {
        super(x);   // calls constructor of PARENT class
        System.out.println("Child parameterized constructor: " + x);
    }
}

public class Main {

    public static void main(String[] args) {

        Child obj = new Child();
    }
}
