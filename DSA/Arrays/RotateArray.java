package DSA.Arrays;

public class RotateArray {
    static void reverse(int arr[], int start, int end) {
        int low = start;
        int high = end;
        while (low < high) {
            int temp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = temp;
        }
    }

    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d, int n) {
        // add your code here
        if(d > n) d %= n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10,12,14,16,18,20};
        rotateArr(arr, 3, arr.length);
    }
}
