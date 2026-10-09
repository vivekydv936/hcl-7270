package Collections;
import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> items = new LinkedList<>();

        // LIST OPERATIONS
        items.add("B");                 // append
        items.addFirst("A");
        items.addLast("C");
        items.add(1, "A2");
        System.out.println("After add: " + items);
        System.out.println("get(1): " + items.get(1));
        System.out.println("getFirst(): " + items.getFirst());
        System.out.println("getLast(): " + items.getLast());

        items.set(1, "B2");
        System.out.println("After set: " + items);
        items.remove("B2");
        items.removeFirst();
        items.removeLast();
        System.out.println("After removals: " + items);

        // QUEUE OPERATIONS
        Queue<String> queue = new LinkedList<>();
        queue.offer("Task1");           // add at tail
        queue.offer("Task2");
        queue.offer("Task3");
        System.out.println("Queue: " + queue);
        System.out.println("peek(): " + queue.peek()); // inspect head
        System.out.println("poll(): " + queue.poll()); // remove head
        System.out.println("Queue after poll: " + queue);

        // STACK-LIKE OPERATIONS AT THE FRONT
        items.push("Top1");
        items.push("Top2");
        System.out.println("After push: " + items);
        System.out.println("pop(): " + items.pop());
        System.out.println("After pop: " + items);

        System.out.println("contains(Task2) in queue: " + queue.contains("Task2"));
        queue.clear();
        System.out.println("Queue after clear: " + queue);
    }
}
