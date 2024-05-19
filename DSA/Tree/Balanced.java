package DSA.Tree;

public class Balanced {
    int balanced(Node node) {
        if (node == null)
            return 0;

        int lh = balanced(node.left);

        if (lh == -1)
            return -1;

        int rh = balanced(node.right);

        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return 1 + Math.max(lh, rh);
    }

    // Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node node) {
        // Your code here
        if (node == null)
            return true;
        return balanced(node) != -1;
    }
}
