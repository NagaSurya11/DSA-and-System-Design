package DSA.Deque;

import java.util.ArrayDeque;

public class ArrayImplementation {
    /**
     * Deque
     */
    public static class Deque {
        private int arr[];
        private int front;
        private int size;
        private int capacity;
        Deque(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            size = 0;
        }

        private boolean isFull() {
            return size == capacity;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        private int last() {
           return (size - 1 + front + capacity) % capacity;
        }

        public void addFirst(int element) {
            if(isFull()) return;
            front = (front - 1 + capacity) % capacity;
            arr[front] = element;
            size++;
        }

        public void addLast(int element) {
            if(isFull()) return;
            size++;
            arr[last()] = element;
        }

        public int pollFirst() {
            if(isEmpty()) return -1;
            int result = arr[front];
            arr[front] = 0;
            front = (front + 1 + capacity) % capacity;
            size--;
            return result;
        }

        public int pollLast() {
            if(isEmpty()) return -1;
            int result = arr[last()];
            arr[last()] = 0;
            size--;
            return result;
        }

        public int peekFirst() {
            if(isEmpty()) return -1;
            return arr[front];
        }

        public int peekLast() {
            if(isEmpty()) return -1;
            return arr[last()];
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addFirst(1);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
    }
}
