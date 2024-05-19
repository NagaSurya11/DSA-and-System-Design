package DSA.Tree;

public class ChildSum {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    // if return 1 else 0
    public static int isSumProperty(Node root) {
        // add your code here
        if (root == null)
            return 1;

        if (root.left == null && root.right == null)
            return 1;

        int sum = 0;

        if (root.left != null)
            sum += root.left.data;
        if (root.right != null)
            sum += root.right.data;

        int result = sum == root.data
                && isSumProperty(root.left) == 1
                && isSumProperty(root.right) == 1 ? 1 : 0;

        return result;
    }
}
