package DSA.Queue;

import java.util.Queue;

public class Operations {
    // Function to push an element in queue.
    void enqueue(Queue<Integer> q, int x) {
        // Code here
        q.add(x);
    }

    // Function to remove front element from queue.
    void dequeue(Queue<Integer> q) {
        // code here
        q.poll();
    }

    // Function to find the front element of queue.
    int front(Queue<Integer> q) {
        // Code here
        return q.peek();
    }

    // Function to find an element in the queue.
    String find(Queue<Integer> q, int x) {
        // Code here
        return q.contains(x) ? "Yes" : "No";
    }
}
