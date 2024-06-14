package DSA.Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class CheckItHasPairOfSum {
    public static int sumExists(int arr[], int N, int sum) {
        // Your code here, Geeks
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (set.contains(sum - arr[i])) {
                return 1;
            } else {
                set.add(arr[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int N = arr.length;
        int sum = 20;
        System.out.println(sumExists(arr, N, sum));
    }
}
