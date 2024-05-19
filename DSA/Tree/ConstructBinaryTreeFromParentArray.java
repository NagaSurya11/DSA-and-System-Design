package DSA.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Queue;

public class ConstructBinaryTreeFromParentArray {
    static class MapValue {
        Node left;
        Node right;
        MapValue(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    // Function to construct binary tree from parent array.
    public static Node createTree(int parent[], int N) {
        // Your code here
        HashMap<Integer, MapValue> map = new HashMap<>();

        Node head = null;

        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) {
                head = new Node(i);
            }
            if (map.containsKey(parent[i])) {
                MapValue temp = map.get(parent[i]);
                temp.right = new Node(i);
                map.put(parent[i], temp);
            } else {
                map.put(parent[i], new MapValue(new Node(i), null));
            }
        }

        if (head == null) return head;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if(map.containsKey(current.data)) {
                MapValue mapValue = map.get(current.data);
                current.left = mapValue.left;
                current.right = mapValue.right;
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int N = 3,
        parent[] = {2, 0, -1};
        new LevelOrderTraversal().traverseAndPrintInDifferentLine(createTree(parent, N));
        Deque<Integer> queue = new ArrayDeque<>().a;
    }
}
