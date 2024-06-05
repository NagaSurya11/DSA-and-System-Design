package DSA.Sorting;

public class HeapSort {
        int parent(int i) {
            return (i - 1) / 2;
        }
        int left(int i) {
            return (2 * i) + 1;
        }
        int right(int i) {
            return (2 * i) + 2;
        }
        //Function to build a Heap from array.
        void buildHeap(int arr[], int n)
        {
            // Your code here
            for(int i = parent(n - 1); i >= 0; i--) {
                heapify(arr, n, i);
            }
        }
        //Heapify function to maintain heap property.
        void heapify(int arr[], int n, int i)
        {
            // Your code here
            int index = i;
            while (index < n) {
                int largest = index;
                if(left(index) < n && arr[left(index)] > arr[largest]) {
                    largest = left(index);
                }
                if(right(index) < n && arr[right(index)] > arr[largest]) {
                    largest = right(index);
                }

                if(largest != index) {
                    int temp = arr[index];
                    arr[index] = arr[largest];
                    arr[largest] = temp;
                    heapify(arr, n, largest);
                }else {
                    return;
                }
            }
        }
        //Function to sort an array using Heap Sort.
        public void heapSort(int arr[], int n)
        {
            //code here
            buildHeap(arr, n);
            for(int i = n - 1; i > 0; i--) {
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
                heapify(arr, i, 0);
            }
        }

        public static void main(String[] args) {
            new HeapSort().heapSort(new int[]{5, 4, 3, 2, 1}, 5);
        }
}
