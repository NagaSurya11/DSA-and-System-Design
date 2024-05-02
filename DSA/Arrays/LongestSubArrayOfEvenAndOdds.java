package DSA.Arrays;

public class LongestSubArrayOfEvenAndOdds {
    // arr[]: input array
    // n: size of array
    // Function to find the length of longest subarray of even and odd numbers.
    public static int maxEvenOdd(int arr[], int n) {
        int count = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            if ((arr[i - 1] % 2 == 0 && arr[i] % 2 != 0)
                    || arr[i - 1] % 2 != 0 && arr[i] % 2 == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
        // your code here
    }

    public static void main(String[] args) {
       int n = 2, a[] = {4, 6};
       System.out.println(maxEvenOdd(a, n));
    }
}
