package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList( "aman", "vivek", "ankit", "rahul", "arjun", "Amit");

        List<String> result = names.stream().filter(name -> name.toLowerCase().startsWith("a")).map(String::toUpperCase).sorted().collect(Collectors.toList());

        System.out.println(result);
    }
}