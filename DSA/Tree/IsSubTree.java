package DSA.Tree;

public class IsSubTree {
    public static boolean isEqual(Node T, Node S) {
        if(T == null && S == null) return true;
        if(T == null || S == null) return false;

        return (T.data == S.data)
        && isEqual(T.left, S.left)
        && isEqual(T.right, S.right);
    }
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if(T == null && S == null) return true;
        if(T == null || S == null) return false;

        if(T.data == S.data && isEqual(T, S)) return true;

        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    public static void main(String[] args) {

        Node T = new Node(26);
        T.left = new Node(10);
        T.left.left = new Node(20);
        T.left.right = new Node(30);
        T.left.left.left = new Node(40);
        T.left.left.right = new Node(60);

        System.out.println(isSubtree(T, T));
    }
}
