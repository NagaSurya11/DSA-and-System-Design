package DSA.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    /**
     * Pair
     */
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.hd = hd;
            this.node = node;
        }
    }
    /**in
     *                      5
     *                  3       6
     *              1       2       7
     */
    static ArrayList <Integer> verticalOrder(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Pair> queue = new ArrayDeque<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                ArrayList<Integer> list = new ArrayList<>();
                if(map.get(pair.hd) != null) {
                    list = map.get(pair.hd);
                }
                list.add(pair.node.data);
                map.put(pair.hd, list);

                if(pair.node.left != null) {
                    queue.add(new Pair(pair.node.left, pair.hd - 1));
                }

                if(pair.node.right != null) {
                    queue.add(new Pair(pair.node.right, pair.hd + 1));
                }
            }
        }
        map.values().forEach(value -> {
            result.addAll(value);
        });
        return result;
    }

}

