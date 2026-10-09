package Collections;
import java.util.*;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> cities = new LinkedHashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Pune");
        cities.add("Delhi"); // duplicate ignored
        System.out.println("Set: " + cities); // insertion order preserved

        System.out.println("contains(Mumbai): " + cities.contains("Mumbai"));
        System.out.println("size(): " + cities.size());

        cities.remove("Pune");
        System.out.println("After remove: " + cities);

        System.out.print("Iteration order: ");
        for (String city : cities) System.out.print(city + " ");

        cities.clear();
        System.out.println("\\nAfter clear: " + cities);
    }
}
