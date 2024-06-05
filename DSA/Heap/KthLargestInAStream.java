package DSA.Heap;

import java.util.PriorityQueue;

public class KthLargestInAStream {
    public void kthLargest(int arr[], int n, int k){
        // Your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            if(queue.size() < k) {
                queue.add(arr[i]);
                System.out.print(-1 + " ");
            }else {
                if(queue.peek() < arr[i]) {
                    queue.poll();
                    queue.add(arr[i]);
                }
                System.out.print(queue.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {
        int k = 3, n = 15, arr[] = {857, 744, 492, 228, 366, 860, 937, 433, 552 ,438, 229, 276, 408, 475, 122};
        new KthLargestInAStream().kthLargest(arr, n, k);
    }
}
