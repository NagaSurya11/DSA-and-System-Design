package DSA.BinarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * FindCommonInTwoBST
 */
public class FindCommonInTwoBST {

    public static ArrayList<Integer> findCommon(Node root1, Node root2) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (root1 != null || root2 != null
                || !s1.isEmpty() || !s2.isEmpty()) {
            while (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }

            if (!s1.isEmpty() && !s2.isEmpty()
                    && s1.peek().data == s2.peek().data) {
                root1 = s1.pop();
                root2 = s2.pop();
                list.add(root1.data);
                root1 = root1.right;
                root2 = root2.right;
            } else if (s2.isEmpty() ||
                    (!s1.isEmpty() && s1.peek().data < s2.peek().data)) {
                root1 = s1.pop();
                root1 = root1.right;
            } else {
                root2 = s2.pop();
                root2 = root2.right;
            }
        }
        return list;
    }
}