package Queue;

import java.util.*;

public class demo {
    public static void main(String[] args) {
        // Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        // q.offer(23);
        // q.offer(45);
        // q.offer(12);
        // System.out.println(q.peek());
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        AD.offer(56);
        AD.add(34);
        
        AD.offer(90);
        System.out.println(AD.peek());


    }
}
