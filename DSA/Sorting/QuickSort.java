package DSA.Sorting;

public class QuickSort {
    public int partition(int arr[], int start, int high) {
        int i = start - 1;
        int j = start;
        int pivot = arr[high];

        for (;j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    public void quickSort(int arr[], int start, int high) {
        if (start > high) {
            return;
        }

        int pIdx = partition(arr, start, high);

        quickSort(arr, start, pIdx - 1);
        quickSort(arr, pIdx + 1, high);
    }

    public void sort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = {10, 8, 1, 5, 2, 6, 7};
        new QuickSort().sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
