package Maps;
import java.util.*;
public class Mymap {
    public static void main(String[] args) {
        Map<Integer,String> mp = new HashMap<>();
        mp.put(1, "vivek");
        mp.put(2, "rahul");
        mp.put(3,"Saurav");
        System.out.println(mp.containsKey(2));
        System.out.println(mp.containsValue("rohit"));

    }
}
