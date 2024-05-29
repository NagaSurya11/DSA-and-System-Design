package DSA.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;


public class ConstructBST {
    /**
     * Pair
     */
    public class Pair {
        Node node;
        int min;
        int max;

        Pair(Node node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public Node levelOrderToBst(int[] arr) {
        // Write your code here
        Node root = null;
        int n = arr.length;
        if (n > 0) {
            root = new Node(arr[0]);

            Queue<Pair> queue = new ArrayDeque<>();

            queue.add(new Pair(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

            int idx = 1;
            while (idx < n) {
                Pair temp = queue.poll();
                if (temp.min <= arr[idx] && arr[idx] < temp.node.data) {
                    Node node = new Node(arr[idx++]);
                    temp.node.left = node;
                    queue.add(new Pair(node, temp.min, temp.node.data));
                }
                if (idx < n && arr[idx] > temp.node.data && arr[idx] <= temp.max) {
                    Node node = new Node(arr[idx++]);
                    temp.node.right = node;
                    queue.add(new Pair(node, temp.node.data, temp.max));
                }
            }
        }
        return root;
    }

    public Node preOrderToBst(int arr[]) {
        int n = arr.length;
        Node root = null;
        if(n == 0) return null;
        root = new Node(arr[0]);
        if(n == 1) return root;

        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        int idx = 1;
        while (idx < n) {
            Pair temp = stack.peek();
            if(temp.min < arr[idx] && arr[idx] < temp.node.data) {
                temp.node.left = new Node(arr[idx++]);
                stack.push(new Pair(temp.node.left, temp.min, temp.node.data));
            }else if(temp.node.data < arr[idx] && arr[idx] < temp.max) {
                temp.node.right = new Node(arr[idx++]);
                stack.push(new Pair(temp.node.right, temp.node.data, temp.max));
            }else {
                stack.pop();
            }
        }
        return root;
    }
    /**
     *                                            7
     *                                   4               12
     *                               3       6        8
     *                           1        5              10
     */
    public static void main(String[] args) {
        int BST[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
        new ConstructBST().levelOrderToBst(BST);
        new ConstructBST().preOrderToBst(new int[]{40,30,35,80,100});
    }
}
