package DSA.Tree;

public class CountNoOfNodesInCompleteBinaryTree {
    /**
     * @implNote only applicable for complete binary tree
     * @implNote O(logn * logn)
     * @param root
     * @return
     */
    int count(Node root) {
        if(root == null) return 0;
        int lh = 0;
        Node lroot = root.left;
        while (lroot != null) {
            lh++;
            lroot = lroot.left;
        }

        int rh = 0;
        Node Rroot = root.right;
        while (Rroot != null) {
            rh++;
            Rroot = Rroot.right;
        }

        if(lh == rh) return 1 + (int) Math.pow(2, lh);

        return 1 + count(root.left) + count(root.right);
    }
}
