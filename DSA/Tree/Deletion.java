package DSA.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Deletion {
    public void deleteDeepest(Node root, Node todel) {
        Queue<Node> queue = new ArrayDeque<>();

        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null && temp.left == todel) {
                temp.left = null;
                break;
            } else if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null && temp.right == todel) {
                temp.right = null;
                break;
            } else if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public Node deletionBT(Node root, int key) {
        // Write your code here and return the root of the changed tree
        Queue<Node> queue = new ArrayDeque<>();

        if (root == null)
            return null;

        queue.add(root);

        Node temp = null;
        Node keyNode = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data == key)
                keyNode = temp;

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
        }

        deleteDeepest(root, temp);
        keyNode.data = temp.data;

        return root;
    }
}
