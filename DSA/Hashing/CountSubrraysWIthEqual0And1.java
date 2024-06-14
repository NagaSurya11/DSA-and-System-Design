package DSA.Hashing;

import java.util.HashMap;

public class CountSubrraysWIthEqual0And1 {
    // Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        // add your code here
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                arr[i] = -1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for(int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if(prefixSum == 0) {
                count++;
            }

            if(map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

}
