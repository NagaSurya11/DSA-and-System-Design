package DSA.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Insertion {
    /**
     * @param root
     * @param node - node to insert
     */
    public void insert(Node root, int key) {
        Queue<Node> queue = new ArrayDeque<>();

        if (root == null) {
            root = new Node(key);
            return;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if(current.left == null) {
                current.left = new Node(key);
                break;
            }else {
                queue.add(current.left);
            }

            if(current.right == null) {
                current.right = new Node(key);
                break;
            }else {
                queue.add(current.right
                );
            }
        }
    }
}
