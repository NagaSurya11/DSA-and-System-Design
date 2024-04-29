package DSA.Arrays;

public class MaxSubarraySum {
    public static int maxSum(int arr[]) {
        int res = arr[0];
        int maxEnding= arr[0];
        for(int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{-6, -2, -3, 1, 5}));
    }
}
