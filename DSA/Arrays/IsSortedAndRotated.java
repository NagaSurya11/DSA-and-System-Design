package DSA.Arrays;

public class IsSortedAndRotated {

    public static void reverse(int arr[], int start, int end) {
        int low = start;
        int high = end;
        while (low < high) {
            int temp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = temp;
        }
    }

    // arr[]: input array
    // num: size of array
    // Function to check if array is sorted and rotated
    public static boolean checkRotatedAndSorted(int arr[], int num) {
        if(num < 3) return true;
        // Your code here
        reverse(arr, 0, num - 1);

        // find sort type
        boolean isIncreasingOrder = arr[0] > arr[1];

        // find no of rotations happened in counter-clockwise
        int rotations = 0;
        for(int i = 0; i < num - 1; i++) {
            if(isIncreasingOrder) {
                if(arr[i] > arr[i + 1]) {
                    rotations++;
                }else {
                    rotations++;
                    break;
                }
            }else {
                if(arr[i] < arr[i + 1]) {
                    rotations++;
                }else {
                    rotations++;
                    break;
                }
            }
        }

        reverse(arr, 0, rotations - 1);
        reverse(arr, rotations, num - 1);

        boolean result = true;
        for(int i = 1; i < num; i++) {
            if(isIncreasingOrder) {
                if(arr[i] < arr[i - 1]) {
                    result = false;
                    break;
                }
            }else {
                if(arr[i] > arr[i - 1]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 4, arr[] = { 3, 4, 1, 2 };
        // int N = 3, arr[] = { 1, 2, 3 };
        System.out.println(        checkRotatedAndSorted(arr, N)
        );
    }
}
