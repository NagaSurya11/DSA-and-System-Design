package DSA.Recursion;

public class SubsetSum {
    public static int getSubsetSumCount(int[] arr, int sum, int i) {
        if(i == 0) {
            return sum == 0 ? 1 : 0;
        }
        return getSubsetSumCount(arr, sum, i - 1)
            + getSubsetSumCount(arr, sum - arr[i - 1], i - 1);
    }
    public static int getSubsetSumCount(int arr[], int sum) {
        return getSubsetSumCount(arr, sum, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(getSubsetSumCount(arr, 4));
    }
}
