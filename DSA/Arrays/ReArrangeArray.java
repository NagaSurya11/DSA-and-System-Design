package DSA.Arrays;

public class ReArrangeArray {
    /**
     * @implNote (1) add every element with (arr[arr[i]] % n) * n
     * @implNote example: arr = [4, 0, 2, 1, 3]
     * @implNote after operation 1 arr = [19, 20, 12, 1, 8]
     * @implNote divide the previous with n , arr = [3, 4, 2, 0, 1]
     * @param arr
     * @param n
     */
    // arr: input array
    // n: size of array
    // Function to rearrange an array so that arr[i] becomes arr[arr[i]]
    // with O(1) extra space.
    static void arrange(long arr[], int n) {
        // your code here
        for (int i = 0; i < n; i++)
            arr[i] += (arr[(int) arr[i]] % n) * n;

        for (int i = 0; i < n; i++)
            arr[i] /= n;
    }

    public static void main(String[] args) {
        int N = 5;
        long arr[] = { 4, 0, 2, 1, 3 };
        arrange(arr, N);
        for(long i: arr) {
            System.out.print(i + " ");
        }
    }
}
