package DSA.Hashing;

import java.util.HashMap;

public class MaxLengthSubArrayOfSum {
        static int maxSubArraySumLength(int arr[], int n, int sum) {
        // add your code here
        int length = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if(prefixSum == sum) {
                length = i + 1;
            }

            if(!map.containsKey(prefixSum - sum)) {
                map.put(prefixSum, i);
            } else {
                length = Math.max(length, i - map.get(prefixSum - sum));
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int n = 5,
        arr[] = {2, 2, 2, 4, 0},
        sum = 6;

        System.out.println(maxSubArraySumLength(arr, n, sum));
    }
}
