package DSA.Hashing;

import java.util.HashSet;

public class HasPrefixSum0 {
    /**
     * @implNote idea is to put all the prefix sum and check if the current sum is exists
     * @param arr
     * @param n
     * @return
     */
    static boolean findsum(int arr[], int n) {
        // Your code here
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for(int element: arr) {
            sum += element;

            if (sum == 0 || element == 0 || set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
    }
}
