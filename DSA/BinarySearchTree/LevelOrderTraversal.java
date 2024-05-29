package DSA.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversal {
    static ArrayList<Integer> levelOrder(Node node) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Node> queue = new ArrayDeque<>();

        if(node != null) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                node = queue.poll();
                result.add(node.data);

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result;
}
public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(2);
    root.right = new Node(7);
    root.left.right = new Node(3);
    root.right.right = new Node(8);
    levelOrder(root).forEach(System.out::println);
}
}

