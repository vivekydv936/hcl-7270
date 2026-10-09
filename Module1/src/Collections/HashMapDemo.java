package Collections;
import java.util.HashMap;
import java.util.Map;


public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();

        // ADD / UPDATE
        students.put(101, "Aman");
        students.put(102, "Vivek");
        students.put(103, "Riya");
        students.put(102, "Vivek Sharma"); // updates key 102
        System.out.println("Map: " + students); // order not guaranteed

        // READ / SEARCH
        System.out.println("get(101): " + students.get(101));
        System.out.println("getOrDefault(999): " + students.getOrDefault(999, "Not found"));
        System.out.println("containsKey(102): " + students.containsKey(102));
        System.out.println("containsValue(Riya): " + students.containsValue("Riya"));
        System.out.println("size(): " + students.size());

        // ADD ONLY IF ABSENT / COMPUTE
        students.putIfAbsent(104, "Neha");
        students.computeIfPresent(103, (key, value) -> value + " Singh");
        System.out.println("After putIfAbsent/computeIfPresent: " + students);

        // ITERATE
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("Keys: " + students.keySet());
        System.out.println("Values: " + students.values());

        // DELETE
        students.remove(101);
        students.remove(104, "Neha"); // removes only if key/value match
        System.out.println("After remove: " + students);

        students.clear();
        System.out.println("After clear: " + students);
        System.out.println("isEmpty(): " + students.isEmpty());
    }
}
