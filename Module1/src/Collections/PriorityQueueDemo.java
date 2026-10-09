package Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(); // min-heap by default

        queue.offer(40);
        queue.offer(10);
        queue.offer(30);
        queue.add(20);
        System.out.println("PriorityQueue internal display: " + queue);

        System.out.println("peek(): " + queue.peek()); // smallest element
        System.out.println("contains(30): " + queue.contains(30));
        System.out.println("size(): " + queue.size());

        System.out.println("poll(): " + queue.poll()); // removes smallest
        System.out.println("remove(): " + queue.remove()); // removes next smallest

        System.out.print("Remaining in priority order: ");
        while (!queue.isEmpty()) System.out.print(queue.poll() + " ");
        System.out.println();

        queue.offer(5);
        queue.offer(2);
        queue.clear();
        System.out.println("After clear: " + queue);
    }
}
