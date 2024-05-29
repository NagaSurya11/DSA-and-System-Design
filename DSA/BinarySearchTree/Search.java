package DSA.BinarySearchTree;

public class Search {

    /**
     * @implNote iterative
     */
    public boolean has(Node head, int key) {
        Node curr = head;
        while (curr != null) {
            if(curr.data == key) {
                return true;
            }
            else if(curr.data < key) {
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }
        return false;
    }

    /**
     * @implNote recursive
     */
    // public boolean has(Node node, int key) {
    //     if(node == null) {
    //         return false;
    //     }
    //     if(node.data == key) {
    //         return true;
    //     }else if(node.data < key) {
    //         return has(node.right, key);
    //     }else {
    //         return has(node.left, key);
    //     }
    // }

    public static void main(String[] args) {
        Node head = Mock.getBSTree(new int[]{15, 5, 20, 3, 18, 80, 16});
        System.out.println(new Search().has(head, 31));
    }
}
