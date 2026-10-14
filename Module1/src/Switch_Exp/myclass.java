package Switch_Exp;

import java.util.*;

public class myclass {
    public static void main(String[] args) {
        int year =2;

   
    
        // switch(year){
        //     case 1 -> System.out.println("he;;o");
        //     case 2 -> System.out.println("day");

        // }


        // String s =switch(year){
        //     case 1 ->"one";
        //     case 2 ->"two";
        //     default ->"unknown";
        // };
        // System.out.println(s);

       


        int day = 2;

        int result = switch (day) {
            case 1 -> 10;
            case 2 -> 20;
            case 3 -> 30;
            default -> 0;
        };

        List<Integer> list = List.of(result);

        System.out.println(list);

   
    }

}
