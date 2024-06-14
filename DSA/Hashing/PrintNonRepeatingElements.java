package DSA.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintNonRepeatingElements {
    // Function to return non-repeated elements in the array.
    static ArrayList<Integer> printNonRepeated(int arr[], int n) {
        // add your code here
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }

        for(int i: arr) {
            if(map.get(i) == 1) {
                list.add(i);
            }
        }
        return list;
    }
}
