package DSA.Stack;

import java.util.Stack;

public class MaxRectangularAreaInHistogram {
    // Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) {
        // your code here
        Stack<Integer> stack = new Stack<>();
        long area = 0;
        int i = 0;
        while(i < n) {
            if(stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            }else {
                area = Math.max(area, hist[stack.pop()] * ((stack.isEmpty()) ? i : i - stack.peek() - 1));
            }
        }
        while (!stack.isEmpty()) {
            area = Math.max(area, hist[stack.pop()] * ((stack.isEmpty()) ? i : n - stack.peek() - 1));
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(getMaxArea(new long[]{6,2,5,4,5,1,6}, 7));
    }
}
