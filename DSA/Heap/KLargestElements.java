package DSA.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {
    public static ArrayList<Integer> kLargest(int[] arr, int n, int k) {
        // code here 
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }

        for(int i = k; i < n; i++) {
            if(arr[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }

        while (!priorityQueue.isEmpty()) {
            list.add(0, priorityQueue.poll());
        }

        return list;
    }
}
