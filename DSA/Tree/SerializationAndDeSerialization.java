package DSA.Tree;

import java.util.ArrayList;

import DSA.Tree.BinaryTree.TraverseType;

public class SerializationAndDeSerialization {
    public void serialize(Node root, ArrayList<Integer> list) {
        if(root == null) {
            list.add(null);
            return;
        }
        list.add(root.data);
        serialize(root.left, list);
        serialize(root.right, list);
    }

    private int index;
    private Node deserialize(Node root, ArrayList<Integer> list) {
        if(index == list.size()) return root;
        if (list.get(index) == null) {
            index++;
            root = null;
            return root;
        }
        root = new Node(list.get(index++));
        root.left = deserialize(root.left, list);
        root.right = deserialize(root.right, list);
        return root;
    }
    public Node deserialize(ArrayList<Integer> list) {
        index = 0;
        Node root = null;
        return deserialize(root, list);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(5);

        ArrayList<Integer> list = new ArrayList<>();
        new SerializationAndDeSerialization().serialize(root, list);
        // list.forEach(System.out::println);

        Node node = new SerializationAndDeSerialization().deserialize(list);

        BinaryTree.traverse(node, TraverseType.INORDER).forEach(System.out::println);
    }
}
