package DSA.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
    /**
     * Pair
     */
    public class Pair {
        int hd;
        Node node;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                if(!map.containsKey(pair.hd)) {
                    map.put(pair.hd, pair.node.data);
                }
                if (pair.node.left != null) {
                    queue.add(new Pair(pair.node.left, pair.hd - 1));
                }
                if (pair.node.right != null) {
                    queue.add(new Pair(pair.node.right, pair.hd + 1));
                }
            }
        }
        map.values().forEach(value -> {
            list.add(value);
        });
        return list;
    }

    public static void main(String[] args) {
        int BST[] = { 7, 4, 12, 3, 6, 8, 13, 1, 5, 10 };
        Node root = new ConstructBST().levelOrderToBst(BST);
        new TopView().topView(root).forEach(System.out::println);
    }
}
