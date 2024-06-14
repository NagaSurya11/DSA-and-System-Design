package DSA.Hashing;

public class LongestCommonSpanofBinaryWIthSameSum {
    public static long longestCommonSubarraySum(int[] arr1, int[] arr2) {
        int diff[] = new int[arr1.length];

        for(int i = 0; i < arr1.length; i++) {
            diff[i] = arr1[i] - arr2[i];
        }

        return MaxLengthSubArrayOfSum.maxSubArraySumLength(diff, diff.length, 0);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 0, 0, 1};
        int[] arr2 = {0, 0, 1, 0, 0, 1};

        System.out.println(longestCommonSubarraySum(arr1, arr2));
    }
}
