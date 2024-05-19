package DSA.Queue;

class MyQueue {

    int front, rear;
    int size = 0;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        if (size == 0) {
            arr[front] = x;
        } else {
            rear = (front + size) % arr.length;
            arr[rear] = x;
        }
        size++;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        // Your code here
        if (size == 0)
            return -1;
        int result = arr[front];
        arr[front] = 0;
        front = (front + 1) % arr.length;
        rear = (front + --size) % arr.length;
        return result;
    }
}
