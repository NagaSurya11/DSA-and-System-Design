package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxAndSecondMax {
    // Function to find largest and second largest element in the array
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]) {
        // code here.
        int first = -1;
        int second = -1;
        for(int i = 1; i < sizeOfArray; i++) {
            if(arr[i] > first) {
                second = first;
                first = arr[i];
            }else if(arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        return new ArrayList<>(List.of(first, second));

    }

    public static void main(String[] args) {
        int N = 3,
        arr[] = {2, 1, 2};
        largestAndSecondLargest(N, arr);
    }
}
