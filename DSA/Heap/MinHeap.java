package DSA.Heap;

public class MinHeap {
    private int arr[];
    private int size;
    private int capacity;

    MinHeap(int capacity) {
        arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    MinHeap(int arr[], int capacity) {
        this.arr = arr;
        this.capacity = capacity;
        size = arr.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }
    public int left(int i) {
        return (2 * i) + 1;
    }

    public int right(int i) {
        return (2 * i) + 2;
    }

    public void insert(int x) {
        if (size == capacity) return;
        arr[size++] = x;
        for (int i = size - 1; i > 0 && arr[parent(i)] > arr[i];) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void heapify(int index) {
        while (index < size) {
            int smallest = index;
            if(left(index) < size && arr[left(index)] < arr[smallest]) {
                smallest = left(index);
            }
            if(right(index) < size && arr[right(index)] < arr[smallest]) {
                smallest = right(index);
            }

            if(smallest != index) {
                int temp = arr[index];
                arr[index] = arr[smallest];
                arr[smallest] = temp;
                index = smallest;
            }else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(10);
        minHeap.insert(40);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(20);
        minHeap.insert(30);

        MinHeap minHeap2 = new MinHeap(new int[]{50, 40, 30, 20, 10}, 10);
        minHeap2.heapify(0);
        minHeap2.heapify(1);
    }
}
