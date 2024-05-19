package DSA.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Stacks {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    // Function to push an element into stack using two queues.
    void push(int a) {
        // Your code here
        q2.add(a);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        q1 = q2;
        q2 = new LinkedList<>();
    }

    // Function to pop an element from stack using two queues.
    int pop() {
        // Your code here
        if (q1.isEmpty())
            return -1;
        return q1.poll();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
    }
}
