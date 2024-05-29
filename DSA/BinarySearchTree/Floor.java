package DSA.BinarySearchTree;

public class Floor {
    public Node floor(Node root, int key) {
        Node result = null;
        Node currentNode = root;
        while (currentNode != null) {
            if(currentNode.data == key) {
                return currentNode;
            }else if(currentNode.data > key) {
                currentNode = currentNode.left;
            }else {
                result = currentNode;
                currentNode = currentNode.right;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Node head = Mock.getBSTree(new int[]{15, 5, 20, 3, 13, 80, 16});
        new Floor().floor(head, 100);
    }
}
