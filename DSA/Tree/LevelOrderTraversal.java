package DSA.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrderTraversal {
    public void traverse(Node root) {
        if(root == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    public void traverseAndPrintInDifferentLine(Node root) {
        if(root == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();

            for(int i = 0; i < count; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int count = queue.size();
            int idx = list.size();
            for(int i = 0; i < count; i++) {
                Node current = queue.poll();
                if(leftToRight) {
                    list.add(current.data);
                }else {
                    list.add(idx, current.data);
                }

                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            leftToRight = !leftToRight;
        }

        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        /**
         *              1
         *          2       3
         *      4       5
         */

         LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
         levelOrderTraversal.traverse(root);
         levelOrderTraversal.traverseAndPrintInDifferentLine(root);

        //  ArrayList<Integer> list = new ArrayList<>();

        //  // step 1
        //  list.add(7);

        //  // step 2
        //  int idx = list.size();
        //  list.add(idx, 9);
        //  list.add(idx, 7);

        //  // step 3
        //  list.add(8);
        //  list.add(8);
        //  list.add(6);

        //  // step 4
        //  idx = list.size();
        //  list.add(idx, 10);
        //  list.add(idx, 9);

         levelOrderTraversal.zigZagTraversal(root).forEach(value -> {
            System.out.print(value + " ");
         });
         System.out.println();
    }
}
