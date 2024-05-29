package DSA.Tree;

public class CountNoOfSubTreesHavingGivenSum {
    int res;

    int countSubtrees(Node root, int X) {
        if (root == null)
            return 0;

        int lsum = (root.left != null) ? countSubtrees(root.left, X) : 0;
        int rsum = (root.right != null) ? countSubtrees(root.right, X) : 0;

        if (lsum + rsum + root.data == X)
            res++;

        return root.data + lsum + rsum;
    }

    int countSubtreesWithSumX(Node root, int X) {
        // Add your code here.
        res = 0;
        if (root == null && X == 0)
            return res;
        countSubtrees(root, X);
        return res;
    }
}
