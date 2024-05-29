package DSA.BinarySearchTree;

import java.util.HashSet;

public class PairSum {
    static boolean findPair(Node root, int sum, HashSet<Integer> set) {
        if(root == null) return false;
        if(findPair(root.left, sum, set)) {
            return true;
        }else {
            if(set.contains(sum - root.data)) {
                return true;
            }else {
                set.add(root.data);
            }
        }
        return findPair(root.right, sum, set);
    }
    //Function to check if any pair exists in BST
    //whose sum is equal to given value.
    static boolean findPair(Node root, int X)
    {
        // Your code
        return findPair(root, X, new HashSet<>());
    }

    public static void main(String[] args) {
        Node root = Mock.getBSTree(new int[]{8, 3, 9, 1, 5});
        System.out.println(findPair(root, 4));
    }
}
