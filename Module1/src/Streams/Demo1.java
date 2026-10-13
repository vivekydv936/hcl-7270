package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        //  List<Integer> numbers =Arrays.asList(1, 2, 3, 4, 5, 6);
        ArrayList<String> l2 = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(12);
        l1.add(11);
        l1.add(116);
        l1.add(1);
        l1.add(2);
        // l1.stream().filter(n ->n%2==0).forEach(System.out::println);
       List<Integer> res = l1.stream().filter(n ->n%2==0).collect(Collectors.toList());

            System.out.println(res);

        // for (Integer num : l1) {
        //     System.out.println(num);
        // }
    }
}
