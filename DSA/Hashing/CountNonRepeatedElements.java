package DSA.Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountNonRepeatedElements {
    // arr[]: input array
    // n: size of array

    // Function to return the count of non-repeated elements in the array.
    static long countNonRepeated(int arr[], int n) {
        // add your code
        long result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }else {
                map.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> set: map.entrySet()) {
            if(set.getValue() == 1) {
                result++;
            }
        }
        return result;
    }
}
