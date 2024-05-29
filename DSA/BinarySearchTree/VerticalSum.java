package DSA.BinarySearchTree;

import java.util.TreeMap;

public class VerticalSum {
    void vSum(Node root, int hd, TreeMap<Integer, Integer> map) {
        if(root == null) return;
        vSum(root.left, hd - 1, map);
        int sum = root.data;
        if(map.containsKey(hd)) {
            sum += map.get(hd);
        }
        map.put(hd, sum);
        vSum(root, hd + 1, map);
    }
    void vSum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        vSum(root, 0, map);
        map.values().forEach(System.out::println);
    }
}
