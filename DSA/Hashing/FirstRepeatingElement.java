package DSA.Hashing;

import java.util.HashMap;

public class FirstRepeatingElement {
    /**
     * The element should occur more than once and the index of its first occurrence should be the smallest.
     * Note:- The position you return should be according to 1-based indexing.
     */
    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        int result = n;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                result = Math.min(result, map.get(arr[i]));
            }else {
                map.put(arr[i], i);
            }
        }
        return result == n ? -1 : result;
    }
}
