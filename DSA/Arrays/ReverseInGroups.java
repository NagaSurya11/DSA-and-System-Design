package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ReverseInGroups {
    void reverse(ArrayList<Integer> arr, int start, int end) {
        int low = start;
        int high = end;
        while (low < high) {
            int temp = arr.set(low++, arr.get(high));
            arr.set(high--, temp);
        }
    }
    // Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        int start = 0;
        int end = k - 1;
        end = end > n - 1 ? n - 1: end;
        while (start < end && end < n) {
            reverse(arr, start, end);
            start += k;
            end += k;
            if(end > n -1) end = n - 1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(5,6,8,9));
        new ReverseInGroups().reverseInGroups(list, list.size(), 3);
    }
}
