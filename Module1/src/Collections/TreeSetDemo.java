package Collections;
import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(20); // duplicate ignored
        System.out.println("Sorted set: " + numbers);

        System.out.println("contains(30): " + numbers.contains(30));
        System.out.println("first(): " + numbers.first());
        System.out.println("last(): " + numbers.last());
        System.out.println("higher(20): " + numbers.higher(20));
        System.out.println("lower(30): " + numbers.lower(30));
        System.out.println("ceiling(25): " + numbers.ceiling(25));
        System.out.println("floor(25): " + numbers.floor(25));
        System.out.println("headSet(30): " + numbers.headSet(30));       // values < 30
        System.out.println("tailSet(20): " + numbers.tailSet(20));       // values >= 20
        System.out.println("subSet(10, 40): " + numbers.subSet(10, 40)); // 10 <= x < 40

        numbers.remove(20);
        System.out.println("After remove: " + numbers);
        numbers.pollFirst();
        numbers.pollLast();
        System.out.println("After pollFirst/pollLast: " + numbers);

        numbers.clear();
        System.out.println("After clear: " + numbers);
    }
}
