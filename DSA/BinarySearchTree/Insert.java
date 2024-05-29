package DSA.BinarySearchTree;

public class Insert {

    /**
     * @apiNote iterative
     * @param root
     * @param key
     * @return
     */
    public Node insert(Node root, int key) {
        Node curr = root;
        Node parent = null;
        while (curr != null) {
            parent = curr;
            if(curr.data < key) {
                curr = curr.right;
            }else if(curr.data > key){
                curr = curr.left;
            }else {
                return root;
            }
        }
        if(parent == null) {
            return new Node(key);
        }else if(parent.data < key) {
            parent.right = new Node(key);
        }else {
            parent.left = new Node(key);
        }
        return root;
    }

    // /**
    //  * @apiNote recursive
    //  * @param root
    //  * @param key
    //  * @return
    //  */
    // public Node insert(Node root, int key) {
    //     if(root == null) {
    //         return new Node(key);
    //     }else if(root.data > key) {
    //         root.left = insert(root.left, key);
    //     }else if(root.data < key) {
    //         root.right = insert(root.right, key);
    //     }
    //     return root;
    // }

    public static void main(String[] args) {
        Node root = null;
        Insert obj = new Insert();
        root = obj.insert(root, 20);
        root = obj.insert(root,10);
        root = obj.insert(root, 30);
        root = obj.insert(root, 25);
        root = obj.insert(root, 18);
        root = obj.insert(root, 10);
    }
}
