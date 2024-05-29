package DSA.Tree;

public class MaxPathSum {
    int res;

    int maxSum(Node node) {
        int ls = (node.left != null) ? maxSum(node.left) : 0;
        int rs = (node.right != null) ? maxSum(node.right) : 0;

        int max = node.data + Math.max(ls + rs, Math.max(ls, rs));
        res = Math.max(res, max);
        return Math.max(node.data + Math.max(ls, rs), node.data);

    }

    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        // your code goes here

        if (node == null)
            return 0;
        res = node.data;
        maxSum(node);

        return res;
    }
}
