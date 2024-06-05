package DSA.Heap;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    // Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) {
        // your code here
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(arr[i]);
        }
        long cost = 0;
        while (!queue.isEmpty() && (queue.size() > 1)) {
                long temp = queue.poll() + queue.poll();
                cost += temp;
                if(!queue.isEmpty())
                    queue.add(temp);
        }
        return cost;
    }

    public static void main(String[] args) {
        new MinimumCostOfRopes().minCost(new long[] { 16 }, 1);
    }
}
