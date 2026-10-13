
package Generics;

// Generic class 1
class Pair<T, V> {
    T key;
    V value;

    Pair(T key, V value) {
        this.key = key;
        this.value = value;
    }

    void display() {
        System.out.println("Key: " + key);
        System.out.println("Value: " + value);
    }
}

// Generic class 2
class Box<T> {
    T data;

    Box(T data) {
        this.data = data;
    }

    void show() {
        System.out.println("Data: " + data);
    }
}

// Main class
public class Generic_Class {
    public static void main(String[] args) {

        Pair<String, Integer> p1 =
            new Pair<>("Vivek", 101);

        Pair<Integer, Double> p2 =
            new Pair<>(20, 85.5);

        Box<String> b1 = new Box<>("Java");
        Box<Integer> b2 = new Box<>(500);

        p1.display();
        System.out.println();

        p2.display();
        System.out.println();

        b1.show();
        b2.show();
    }
}












