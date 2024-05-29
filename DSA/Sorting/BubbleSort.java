package DSA.Sorting;

/**
 * @algorithm {BubbleSort}
 * @implNote swap if current element is greater than next untill n - 1 or already sorted
 */
public class BubbleSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            boolean isAlreadySorted = true;
            for(int j = 0; j < n - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isAlreadySorted = false;
                }
            }
            if(isAlreadySorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4 , 5, 3};
        new BubbleSort().sort(arr);
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}
