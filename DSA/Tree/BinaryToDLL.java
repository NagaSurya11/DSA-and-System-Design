package DSA.Tree;

public class BinaryToDLL {
    Node prev;
    Node bToDLL(Node node) {
        if(node == null) {
            return node;
        }
        Node head = bToDLL(node.left);

        if(prev == null) {
            head = node;
        }else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        bToDLL(node.right);
        return head;
    }

    Node bTreeToClist(Node root)
    {
        //your code here
        prev = null;
        Node head = bToDLL(root);
        prev.right = head;
        head.left = prev;
        return head;
    }
}
