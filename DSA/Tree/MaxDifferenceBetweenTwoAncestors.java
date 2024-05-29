package DSA.Tree;

public class MaxDifferenceBetweenTwoAncestors {
    // Function to return the maximum difference between any
    // node and its ancestor.
    int res;
    int maxDiffUtil(Node node) {
        if(node == null) return Integer.MAX_VALUE;
        if(node.left == null && node.right == null) return node.data;
        int val = Math.min(maxDiffUtil(node.left), maxDiffUtil(node.right));

        res = Math.max(res, node.data - val);
        return Math.min(val, node.data);
    }

    int maxDiff(Node root) {
        // your code here
        res = Integer.MIN_VALUE;
        if (root == null)
            return 0;
        maxDiffUtil(root);
        return res;
    }
}
