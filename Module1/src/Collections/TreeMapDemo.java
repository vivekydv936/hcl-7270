package Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> students = new TreeMap<>();

        students.put(103, "Riya");
        students.put(101, "Aman");
        students.put(102, "Vivek");
        System.out.println("Sorted by key: " + students);

        System.out.println("get(102): " + students.get(102));
        System.out.println("firstKey(): " + students.firstKey());
        System.out.println("lastKey(): " + students.lastKey());
        System.out.println("firstEntry(): " + students.firstEntry());
        System.out.println("lastEntry(): " + students.lastEntry());
        System.out.println("higherKey(101): " + students.higherKey(101));
        System.out.println("lowerKey(103): " + students.lowerKey(103));
        System.out.println("headMap(103): " + students.headMap(103)); // keys < 103
        System.out.println("tailMap(102): " + students.tailMap(102)); // keys >= 102
        System.out.println("subMap(101, 103): " + students.subMap(101, 103));

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        students.replace(102, "Vivek Sharma");
        students.remove(101);
        System.out.println("After replace/remove: " + students);

        students.clear();
        System.out.println("After clear: " + students);
    }
}
