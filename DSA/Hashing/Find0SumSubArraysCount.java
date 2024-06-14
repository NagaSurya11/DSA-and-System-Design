package DSA.Hashing;

import java.util.HashMap;

public class Find0SumSubArraysCount {
    // Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr, int n) {
        // Your code here
        long count = 0;
        long sum = 0;

        long defaultValue = 0;

        HashMap<Long, Long> prefixSumMap = new HashMap<>();
        for (long i: arr) {
            sum += i;

            if (sum == 0) {
                count++;
            }

            if (prefixSumMap.containsKey(sum)) {
                count += prefixSumMap.get(sum);
            }

            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, defaultValue) + 1);

        }
        return count;
    }
}
