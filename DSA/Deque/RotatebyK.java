package DSA.Deque;

import java.util.ArrayDeque;

public class RotatebyK {
    // Function to rotate deque by k places in anti-clockwise direction.
    public static void left_Rotate_Deq_ByK(ArrayDeque<Integer> deque, int n, int k) {
        // Your code here
        int i = 0;
        while (i < k) {
            deque.addLast(deque.pollFirst());
            i++;
        }
    }

    // Function to rotate deque by k places in clockwise direction.
    public static void right_Rotate_Deq_ByK(ArrayDeque<Integer> deque, int n, int k) {
        // Your code here
        int i = 0;
        while (i < k) {
            deque.addFirst(deque.pollLast());
            i++;
        }
    }
}
