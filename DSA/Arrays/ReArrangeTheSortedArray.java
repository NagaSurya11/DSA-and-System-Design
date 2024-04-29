package DSA.Arrays;

public class ReArrangeTheSortedArray {
    /**
     * @implNote arr = {1, 2, 3, 4, 5, 6}
     * @implNote divisor = max + 1 = 6 + 1 = 7
     * @implNote place two pointers 1 at start and 1 at end
     * @implNote arr[i] += (arr[j] % divisor) * divisor; arr[i + 1] = i; i+=2
     * @implNote {43, 9, 38, 18, 33, 27}
     * @implNote arr[i] /= divisor
     * @implNote {6, 1, 5, 2, 4, 3}
     */
    // arr: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        // Your code here
        // find divisor
        long divisor = arr[n - 1] + 1;
        // iteration
        int iteration = 1;
        int idx = 0;
        while (idx < n - 1) {
            arr[idx++] += ((arr[n - iteration] % divisor) * divisor);
            arr[idx] += ((arr[idx++ - iteration++] % divisor) * divisor);
        }
        // if n is odd
        if(idx == n - 1) {
            arr[idx] += ((arr[n - iteration] % divisor) * divisor);
        }
        for(int i = 0; i < n; i++) {
            arr[i] /= divisor;
        }
    }

    public static void main(String[] args) {
        // long arr[] = {1, 2, 3, 4, 5, 6};
        long arr[] = {10,20,30,40,50,60,70,80,90,100,110};
        int n = arr.length;
        rearrange(arr, n);
    }
}
