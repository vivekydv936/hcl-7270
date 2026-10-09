package Collections;
import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> scores = new LinkedHashMap<>();

        scores.put("Aman", 80);
        scores.put("Vivek", 95);
        scores.put("Riya", 88);
        scores.put("Vivek", 97); // updates value; key order remains
        System.out.println("Map: " + scores); // insertion order preserved

        System.out.println("get(Aman): " + scores.get("Aman"));
        System.out.println("containsKey(Riya): " + scores.containsKey("Riya"));
        System.out.println("containsValue(88): " + scores.containsValue(88));
        scores.putIfAbsent("Neha", 91);

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " scored " + entry.getValue());
        }

        scores.remove("Aman");
        System.out.println("After remove: " + scores);
        System.out.println("size(): " + scores.size());

        scores.clear();
        System.out.println("After clear: " + scores);
    }
}
