package Collections;
import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // ADD AT BOTH ENDS
        deque.addFirst("B");
        deque.addLast("C");
        deque.offerFirst("A");
        deque.offerLast("D");
        System.out.println("Deque: " + deque);

        // INSPECT
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());
        System.out.println("peekFirst(): " + deque.peekFirst());
        System.out.println("peekLast(): " + deque.peekLast());
        System.out.println("contains(C): " + deque.contains("C"));

        // REMOVE AT BOTH ENDS
        System.out.println("removeFirst(): " + deque.removeFirst());
        System.out.println("pollLast(): " + deque.pollLast());
        System.out.println("After removals: " + deque);

        // USE AS A STACK
        deque.push("Top1");
        deque.push("Top2");
        System.out.println("After push: " + deque);
        System.out.println("pop(): " + deque.pop());
        System.out.println("After pop: " + deque);

        deque.clear();
        System.out.println("After clear: " + deque);
    }
}
