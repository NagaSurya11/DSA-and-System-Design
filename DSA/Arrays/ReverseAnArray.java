package DSA.Arrays;

public class ReverseAnArray {
    public static void reverse(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int temp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        reverse(arr);
        for (int i : arr) {
            System.out.print(i + " "); 
        }
    }
}
