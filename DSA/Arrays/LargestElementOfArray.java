package DSA.Arrays;

public class LargestElementOfArray {
    public static int indexOfLargestElement(int[] arr) {
        int idx = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[idx] < arr[i]) {
                idx = i;
            }
        }
        return idx;
    }
}
