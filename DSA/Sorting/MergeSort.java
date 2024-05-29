package DSA.Sorting;


/**
 * @algorithm {MergeSort}
 * @implNote Divide and seperate in twoarrays merge by comparing
 */
public class MergeSort {
    public void merge(int arr[], int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int arr1[] = new int[(mid - start) + 1];
        int arr2[] = new int[end - mid];
        while (i <= mid) {
            arr1[i - start] = arr[i++];
        }
        while (j <= end) {
            arr2[j - (mid + 1)] = arr[j++];
        }
        i = 0;
        j = 0;
        int k = start;
        while (i < arr1.length && j < arr2.length) {
            int temp;
            if(arr1[i] < arr2[j]) {
                temp = arr1[i++];
            }else {
                temp = arr2[j++];
            }
            arr[k++] = temp;
        }

        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
    }
    public void sort(int arr[], int start, int end) {
        if(start == end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }
    public void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        int arr[] = {10, 8, 1, 5, 2, 6, 7};
        new MergeSort().sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
