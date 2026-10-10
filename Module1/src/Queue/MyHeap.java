package Queue;

import java.util.*;

/**
 * MyHeap
 */
public class MyHeap {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(12);
        pq.offer(34);
        pq.offer(50);
        System.out.println(pq.peek());
    }


}