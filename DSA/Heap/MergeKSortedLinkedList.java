package DSA.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

import DSA.LinkedList.Mock;
import DSA.LinkedList.Node;

public class MergeKSortedLinkedList {
    // /**
    //  * Node
    //  */
    // public class Node {
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //     }
    // }

    // Function to merge K sorted linked list.
    Node mergeKList(Node[] arr, int k) {
        Comparator<Node> comparator = (o1, o2) -> Integer.compare(o1.data, o2.data);
        PriorityQueue<Node> queue = new PriorityQueue<>(comparator);
        Node root = null;
        Node prev = null;
        for(int i = 0; i < k; i++) {
            if(arr[i] != null) {
                queue.add(arr[i]);
            }
        }

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(root == null && prev == null) {
                root = prev = temp;
            }else {
                prev.next = temp;
                prev = temp;
            }

            if(temp.next != null) {
                queue.add(temp.next);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node[] arr = {
            Mock.getNode(new int[]{1, 2, 3}),
            Mock.getNode(new int[]{4, 5, 6}),
            Mock.getNode(new int[]{7, 8, 9})
        };
        Node result = new MergeKSortedLinkedList().mergeKList(arr, arr.length);
    }
}
