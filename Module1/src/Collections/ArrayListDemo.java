package Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        // CREATE / ADD
        names.add("Aman");                  // append
        names.add("Vivek");
        names.add("Riya");
        names.add(1, "Neha");               // insert at index 1
        System.out.println("After add: " + names);

        // READ
        System.out.println("get(0): " + names.get(0));
        System.out.println("size(): " + names.size());
        System.out.println("contains(Vivek): " + names.contains("Vivek"));
        System.out.println("indexOf(Riya): " + names.indexOf("Riya"));

        // UPDATE

        names.set(0, "Arjun");
        System.out.println("After set: " + names);

        // DELETE
        names.remove("Neha");               // remove by value
        names.remove(0);                    // remove by index
        System.out.println("After remove: " + names);

        // ITERATE
        System.out.print("For-each: ");
        for (String name : names) System.out.print(name + " ");
        System.out.println();

        Iterator<String> it = names.iterator();
        while (it.hasNext()) 
            System.out.println("Iterator: " + it.next());

        // SORT / REVERSE
        names.add("Karan");
        Collections.sort(names);
        System.out.println("Sorted: " + names);
        Collections.reverse(names);
        System.out.println("Reversed: " + names);

        // CLEAR / EMPTY CHECK
        System.out.println("isEmpty(): " + names.isEmpty());
        names.clear();
        System.out.println("After clear: " + names);
        System.out.println("isEmpty(): " + names.isEmpty());
    }
}
