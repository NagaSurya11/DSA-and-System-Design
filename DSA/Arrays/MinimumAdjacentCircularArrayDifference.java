package DSA.Arrays;

public class MinimumAdjacentCircularArrayDifference {
    // Function to find minimum adjacent difference in a circular array.
    // arr[]: input array
    // n: size of array
    public static int minAdjDiff(int arr[], int n) {

        // Your code here
        int minDiff = arr[0] - arr[1];
        for(int i = 1; i < n; i++) {
            if(i == n -1) {
                minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[0]));
            }else {
                minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i + 1]));
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int arr[] = {10,-3,-4,7,6,5,-4,-1};
        minAdjDiff(arr, arr.length);
    }
}
