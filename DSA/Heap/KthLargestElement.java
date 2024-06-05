package DSA.Heap;

public class KthLargestElement {
    private static int parent(int index) {
        return (index - 1) / 2;
    }

    private static int left(int index) {
        return (2 * index) + 1;
    }

    private static int right(int index) {
        return (2 * index) + 2;
    }

    private static void heapify(int[] arr, int size, int i) {
        int index = i;
        while (index < size) {
            int largest = index;
            if(left(index) < size && arr[left(index)] > arr[largest]) {
                largest = left(index);
            }
            if(right(index) < size && arr[right(index)] > arr[largest]) {
                largest = right(index);
            }

            if(index != largest) {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                index = largest;
            }else {
                return;
            }
        }
    }

    private static void buildHeap(int[] arr, int size) {
        for(int i = parent(size - 1); i >= 0; i--) {
            heapify(arr, size, i);
        }
    }

    public static int KthLargest(int[] arr, int size, int k) {
        buildHeap(arr, size);
        int i = size - 1;
        for(; i >= size - k; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
        return arr[i + 1];
    }

    public static void main(String[] args) {
        int k = 4;
        int n = 5;
        int arr[] = {3, 5, 4, 2, 9};
        KthLargest(arr, n, k);
    }
}
