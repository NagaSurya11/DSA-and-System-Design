package DSA.Sorting;

public class InsertionSort {
    /**
     * @algorithm {InsertionSort}
     * @implNote pick an elemment from un sorted array and put inside sorted array in correct position
     * @param arr
     */
    public void sort(int arr[]) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1; // last element of sorted array

            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j--];
            }

            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{10, 1, 2, 5, 3};
        new InsertionSort().sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
