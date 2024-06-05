package DSA.Heap;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallest(int arr[], int n, int k)
    {
        // Your code here
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) ->
            Integer.compare(o2, o1)
        ));

        for(int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }

        for(int i = k; i < n; i++) {
            if(priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        kthSmallest(new int[]{3, 5, 4, 2, 9}, 5, 3);
    }
}
