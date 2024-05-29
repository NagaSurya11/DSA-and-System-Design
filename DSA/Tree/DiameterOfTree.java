package DSA.Tree;

public class DiameterOfTree {
    int res;

    int height(Node root) {

        int lh = (root.left != null) ? height(root.left) : 0;
        int rh = (root.right != null) ? height(root.right) : 0;

        res = Math.max(res, 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }

    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        // Your code here
        res = 0;
        if (root == null)
            return res;
        height(root);
        return res;
    }
}
