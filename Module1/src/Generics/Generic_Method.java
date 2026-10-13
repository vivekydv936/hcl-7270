
package Generics;

class Generic_Method {

    //  Display any value
    public <T> void display(T value) {
        System.out.println(value);
    }

    //  Return any value
    public <T> T getValue(T value) {
        return value;
    }

    //  Accept two values of the same type
    public <T> void printTwo(T a, T b) {
        System.out.println(a + " " + b);
    }

    //  Accept two different types
    public <T, V> void printPair(T a, V b) {
        System.out.println(a + " : " + b);
    }

    public static void main(String[] args) {
        Generic_Method obj = new Generic_Method();

        obj.display(10);
        obj.display("Vivek");

        String name = obj.getValue("Java");
        System.out.println(name);

        obj.printTwo(10, 20);
        obj.printTwo("Hello", "World");

        obj.printPair(101, "Vivek");
        obj.printPair("Age", 21);
    }
}
