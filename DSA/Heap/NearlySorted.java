package DSA.Heap;

import java.util.PriorityQueue;

public class NearlySorted {
    public void sort(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i <= k; i++) {
            priorityQueue.add(arr[i]);
        }
        int index = 0;
        for(int i = k + 1; i < arr.length; i++) {
            arr[index++] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
        while(!priorityQueue.isEmpty()) {
            arr[index++] = priorityQueue.poll();
        }
    }
}
