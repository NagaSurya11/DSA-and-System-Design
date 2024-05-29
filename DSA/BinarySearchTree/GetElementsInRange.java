package DSA.BinarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

public class GetElementsInRange {
    public static ArrayList<Integer> printNearNodes(Node root,
            int low, int high) {
        // code here.
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (low > root.data) {
            root = root.right;
        }
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                if (low <= root.data && root.data <= high) {
                    list.add(root.data);
                }
                root = root.right;
            }
        }
        return list;
    }
}
