package DSA.Hashing;

import java.util.HashMap;

public class SubArrayWithGivenSum {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int n, int sum) {
        // add your code here
        int count = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        for (int i : arr) {
            prefixSum += i;

            if (prefixSum == sum) {
                count++;
            }

            if (prefixSumMap.containsKey(prefixSum - sum)) {
                count += prefixSumMap.get(prefixSum - sum);
            }

            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 5,
                arr[] = { 10, 2, -2, -20, 10 },
                sum = -10;
        System.out.println(subArraySum(arr, n, sum));
    }
}
