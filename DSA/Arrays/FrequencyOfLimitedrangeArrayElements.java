package DSA.Arrays;

public class FrequencyOfLimitedrangeArrayElements {
    /**
     * @implNote arr = [2, 3, 2, 3, 5], N = 5, P = 5
     * @implNote P is a divisor
     * @implNote if value = 2 need to set frequency on idx 1
     * @implNote Subratact All By one
     * @implNote arr = {1, 2, 1, 2, 4}
     * @implNote arr[(arr[i]) % P] += P;
     * @implNote {1, 13, 11, 2, 9}
     * @implNote arr[i] /= P
     * @implNote {0, 2, 2, 0, 1}
     * @param arr
     * @param N
     * @param P
     */
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // code here
        for(int i = 0; i < N; i++) {
            arr[i] -= 1;
        }
        for(int i = 0; i < N; i++) {
            arr[(arr[i]) % P] += P;
        }
        for(int i = 0; i < N; i++) {
            arr[i] /= P;
        }
    }
}
