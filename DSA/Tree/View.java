package DSA.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class View {
    public class QueueObj {
        Node node;
        int hd;

        QueueObj(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    // private int max;
    // /**
    // * @implNote recursive
    // * @param node
    // * @param level
    // */
    // private void leftView(Node node, int level) {
    // if(node == null) return;
    // if(max < level) {
    // max = level;
    // System.out.print(node.data + " ");
    // }
    // leftView(node.left, level + 1);
    // leftView(node.right, level + 1);
    // }

    // public void printLeftView(Node root) {
    // max = 0;
    // leftView(root, 1);
    // }

    public void printLeftView(Node node) {
        if (node == null)
            return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int count = queue.size();

            for (int i = 0; i < count; i++) {
                Node current = queue.poll();

                // print only one for level 1
                if (i == 0)
                    System.out.print(current.data + " ");

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
        System.out.println();
    }

    public void printRightView(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int count = queue.size();

            for (int i = 0; i < count; i++) {
                Node current = queue.poll();
                if (i == count - 1) {
                    System.out.print(current.data + " ");
                }
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
        System.out.println();
    }

    public void printTopView(Node root) {
        if (root == null)
            return;

        Queue<QueueObj> queue = new ArrayDeque<>();

        queue.add(new QueueObj(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            QueueObj current = queue.poll();
            if (!map.containsKey(current.hd)) {
                map.put(current.hd, current.node.data);
            }

            if (current.node.left != null) {
                queue.add(new QueueObj(current.node.left, current.hd - 1));
            }

            if (current.node.right != null) {
                queue.add(new QueueObj(current.node.right, current.hd + 1));
            }
        }

        map.keySet().stream().forEach(key -> {
            System.out.print(map.get(key) + " ");
        });
        System.out.println();
    }

    public void mirror(Node node) {
        // Your code here
        if (node == null)
            return;

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null)
            mirror(node.left);
        if (node.right != null)
            mirror(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        /**
         * 1
         * 2 3
         * 4 5 6 7
         * 8
         */
        View view = new View();
        view.printLeftView(root);
        view.printRightView(root);
        view.printTopView(root);
    }
}
