package Collections;
import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();

        // Hashtable is synchronized and does not allow null keys or values.
        table.put(1, "One");
        table.put(2, "Two");
        table.put(3, "Three");
        table.put(2, "TWO"); // update
        System.out.println("Hashtable: " + table);

        System.out.println("get(1): " + table.get(1));
        System.out.println("containsKey(2): " + table.containsKey(2));
        System.out.println("containsValue(Three): " + table.containsValue("Three"));
        System.out.println("size(): " + table.size());

        table.putIfAbsent(4, "Four");
        for (Map.Entry<Integer, String> entry : table.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        table.remove(3);
        System.out.println("After remove: " + table);

        table.clear();
        System.out.println("After clear: " + table);
        System.out.println("isEmpty(): " + table.isEmpty());
    }
}
