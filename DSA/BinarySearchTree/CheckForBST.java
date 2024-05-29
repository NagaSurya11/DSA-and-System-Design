package DSA.BinarySearchTree;

public class CheckForBST {

    Node prev;
    /**
     * @description using inorder traversal whether previous is smaller than current
     * @param root
     * @param prev
     */
    public boolean isBST(Node root) {
        if(root == null) {
            return true;
        }
        if(!isBST(root.left)) return false;
        if(prev != null && root.data <= prev.data) return false;
        prev = root;
        return isBST(root.right);
    }

    public boolean isBST(Node root, int min, int max) {
        if(root == null) return true;
        if(min >= root.data || max <= root.data) return false;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    /**
     *                      10
     *              5               18
     *         1        7       11      20
     */

     public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(5);
        head.right  = new Node(11);
        System.out.println(new CheckForBST().isBST(head));
        System.out.println(new CheckForBST().isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE));
     }
}
