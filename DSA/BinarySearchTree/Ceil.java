package DSA.BinarySearchTree;

public class Ceil {
    int findCeil(Node root, int key) {
        if (root == null)
            return -1;
        // Code here
        Node curr = root;
        Node result = root.data > key ? root : null;

        while (curr != null) {
            if (curr.data == key) {
                return key;
            } else if (curr.data > key) {
                if (result == null) {
                    result = curr;
                } else if (result.data > curr.data
                        && curr.data > key) {
                    result = curr;
                }
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return result == null ? -1 : result.data;
    }
}
