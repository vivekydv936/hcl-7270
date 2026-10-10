package Queue;

import java.util.*;

public class StackUsingArrayDeque {

    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();

        
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack);

        
        System.out.println("Top element: " + stack.peek());

        
        System.out.println("Removed: " + stack.pop());

        System.out.println("Stack after pop: " + stack);

        
        System.out.println("Contains 10: " + stack.contains(10));

   
        System.out.println("Size: " + stack.size());

        
        System.out.println("Is empty: " + stack.isEmpty());

        
        stack.clear();

        System.out.println("After clear: " + stack);
    }
}

    
