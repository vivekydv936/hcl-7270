package Collections;
import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();

        // ADD (duplicates are ignored)
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Apple");
        System.out.println("Set: " + fruits); // order is not guaranteed

        // SEARCH / SIZE
        System.out.println("contains(Mango): " + fruits.contains("Mango"));
        System.out.println("size(): " + fruits.size());

        // DELETE
        fruits.remove("Banana");
        System.out.println("After remove: " + fruits);

        // ITERATE
        for (String fruit : fruits) System.out.println(fruit);

        // SET OPERATIONS
        Set<String> other = new HashSet<>();
        other.add("Mango");
        other.add("Orange");

        Set<String> union = new HashSet<>(fruits);
        union.addAll(other);
        System.out.println("Union: " + union);

        Set<String> intersection = new HashSet<>(fruits);
        intersection.retainAll(other);
        System.out.println("Intersection: " + intersection);

        Set<String> difference = new HashSet<>(fruits);
        difference.removeAll(other);
        System.out.println("Difference: " + difference);

        fruits.clear();
        System.out.println("After clear: " + fruits);
        System.out.println("isEmpty(): " + fruits.isEmpty());
    }
}
