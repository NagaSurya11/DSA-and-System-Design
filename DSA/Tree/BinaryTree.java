package DSA.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinaryTree {
    public enum TraverseType {
        INORDER,
        PREORDER,
        POSTORDER
    }
    /**
     * @implNote Left -> Root -> Right
     */
    private static void inOrderTraversal(Node node, ArrayList<Integer> list) {
        if(node == null) return;
        inOrderTraversal(node.left, list);
        list.add(node.data);
        inOrderTraversal(node.right, list);
    }

    /**
     * @implNote Root -> Left -> Right
     */
    static void preOrderTraversal(Node node, ArrayList<Integer> list) {
        if(node == null) return;
        list.add(node.data);
        preOrderTraversal(node.left, list);
        preOrderTraversal(node.right, list);
    }

    /**
     * @implNote Left -> Right -> Root
     */
    static void postOrderTraversal(Node node, ArrayList<Integer> list) {
        if(node == null) return;
        postOrderTraversal(node.left, list);
        postOrderTraversal(node.right, list);
        list.add(node.data);
    }

    public static ArrayList<Integer> traverse(Node root, TraverseType type) {
        ArrayList<Integer> result = new ArrayList<>();
        switch (type) {
            case INORDER:
                inOrderTraversal(root, result);
                break;
            case PREORDER:
                preOrderTraversal(root, result);
                break;
            case POSTORDER:
                postOrderTraversal(root, result);
                break;
            default:
                break;
        }
        return result;
    }

    static void print(ArrayList<Integer> list) {
        list.forEach((value) -> {
            System.out.print(value + " ");
        });
        System.out.println();
    }

    static int height(Node node) {
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static void printNodesAtKheight(Node node, int k) {
        if(node == null) return;
        if(k == 0){
            System.out.print(node.data + " ");
        }
        else {
            printNodesAtKheight(node.left, k - 1);
            printNodesAtKheight(node.right, k - 1);
        }
    }
    private static int cnt;

    static int printKDistantfromLeaf(Node root, int k) {
        cnt = 0;
        Map<Integer, Boolean> mp = new HashMap<>();
        dfs(root, k, 0, mp);
        return (int) mp.values().stream().filter(value -> value).count();
    }

    private static void dfs(Node node, int k, int lvl, Map<Integer, Boolean> mp) {
        if (node == null)
            return;

        mp.put(lvl, false);

        if (node.left == null && node.right == null) {
            if (lvl - k >= 0 && (mp.get(lvl-k) == null || mp.get(lvl-k) == false)) {
                mp.put(lvl - k, true);
                cnt++;
            }
        }

        lvl++;
        dfs(node.left, k, lvl, mp);
        dfs(node.right, k, lvl, mp);
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    public static int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(max(root.left), max(root.right)));
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
        // print(traverse(root, TraverseType.INORDER));
        // System.out.println(height(root));
        // printNodesAtKheight(root, 1);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        /**
         *                  1
         *          2              3
         *     4       5       6        7
         *                         8
         */
        // System.out.println(printKDistantfromLeaf(root, 2));

        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(7);
        node.left.left = new Node(0);

        /**
         *              4
         *          2       7
         *      0
         */
        // System.out.println(printKDistantfromLeaf(node, 0));

        // System.out.println(size(node));
        System.out.println(max(root));

    }
}
