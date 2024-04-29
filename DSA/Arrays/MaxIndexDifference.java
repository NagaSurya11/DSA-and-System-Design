package DSA.Arrays;

/**
 * MaxIndexDifference
 */
public class MaxIndexDifference {

        // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) {
        int res = 0;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = a[0];
        for(int i = 1; i < n; i++) {
            left[i] = Math.min(a[i], left[i - 1]);
        }
        right[n - 1] = a[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(a[i], right[i + 1]);
        }
        int low = 0;
        int high = 0;
        while (low < n && high < n) {
            if(left[low] <= right[high]) {
                res = Math.max(res, high - low);
                high++;
            }else {
                low++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int n = 9,
        a[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};

        System.out.println(maxIndexDiff(a, n));
    }
}