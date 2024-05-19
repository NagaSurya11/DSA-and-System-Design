package DSA.Stack;

import java.util.Stack;

public class GreaterElement {
    static long[] getNextGreaterElement(long arr[]) {
        // long result[] = new long[n];
        // Stack<Integer> stack = new Stack<>();
        // for(int i = 0; i < n; i++) {
        //     long curr = arr[i];
        //     while(!stack.isEmpty() && arr[stack.peek()] < curr) {
        //         result[stack.pop()] = curr;
        //     }
        //     stack.push(i);
        // }
        // while(!stack.isEmpty()) {
        //     result[stack.pop()] = -1;
        // }
        // return result;
        long result[] = new long[arr.length];
        Stack<Long> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
    static int[] getPreviousGreaterElement(int arr[]) {
        int result[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            };
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        long arr[] = {5, 15, 10, 8, 6, 12, 9, 18};
        long result[] = getNextGreaterElement(arr);

    }
}
