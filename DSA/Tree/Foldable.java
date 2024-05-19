package DSA.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Foldable {
    boolean isEqualAfterMirror(Node T, Node S) {
        if((T == null && S == null)) return true;
        if(T == null && S != null || T != null && S == null) return false;
        Node temp = T.left;
        T.left = T.right;
        T.right = temp;
        return (T != null && S != null) && isEqualAfterMirror(T.left, S.left) && isEqualAfterMirror(T.right, S.right);
    }
    boolean IsFoldable(Node node) {
        if(node == null) return true;
        return isEqualAfterMirror(node.left, node.right);
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(7);
        node.right = new Node(15);
        node.left.right = new Node(9);
        node.right.left = new Node(11);

        System.out.println(new Foldable().IsFoldable(node));
    }
}
