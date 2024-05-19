package DSA.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LinkedListToTree {
    class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

        // Function to make binary tree from linked list.
        public static Tree convert(Node head, Tree node) {
            // add code here.
            if (head == null)
                return null;

            Queue<Tree> queue = new ArrayDeque<>();

            node = new Tree(head.data);

            queue.add(node);

            head = head.next;

            while (head != null) {
                Tree current = queue.poll();
                current.left = new Tree(head.data);
                head = head.next;
                queue.add(current.left);
                if (head != null) {
                    current.right = new Tree(head.data);
                    head = head.next;
                    queue.add(current.right);
                }
            }

            return node;

        }
    }
}
