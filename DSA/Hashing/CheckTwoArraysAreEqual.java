package DSA.Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class CheckTwoArraysAreEqual {
    // Function to check if two arrays are equal or not.
    public static boolean check(long A[], long B[], int N) {
        // Your code here
        HashMap<Long, Integer> map = new HashMap<>();

        for(long i: A) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }

        for(long i: B) {
            if(map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
            }else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        long A[] = new long[]{2, 2, 2, 5};
        long B[] = new long[]{2, 2, 2, 5};
        System.out.println(check(A, B, 4));
    }
}
