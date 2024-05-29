package DSA.BinarySearchTree;

public class Delete {
    public Node getSuccessor(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    public Node delete(Node root, int key) {
        if(root == null) return null;

        if(root.data > key) {
            root.left = delete(root.left, key);
        }else if(root.data < key) {
            root.right = delete(root.right, key);
        }else {
            if(root.left == null) {
                return root.right;
            }else if(root.right == null) {
                return root.left;
            }else {
                Node successor = getSuccessor(root);
                root.data = successor.data;
                root.right = delete(root.right, successor.data);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node head = Mock.getBSTree(new int[]{15, 5, 20, 3, 13, 80, 16});
        new Delete().delete(head, 20);
    }
}

