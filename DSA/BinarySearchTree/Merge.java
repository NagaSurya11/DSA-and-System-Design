package DSA.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Merge {
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while(root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }
            if(stack2.isEmpty() || (!stack1.isEmpty() && (stack1.peek().data <= stack2.peek().data))) {
                root1 = stack1.peek();
                stack1.pop();
                list.add(root1.data);
                root1 = root1.right;
            }else {
                root2 = stack2.peek();
                stack2.pop();
                list.add(root2.data);
                root2 = root2.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(6);

        new Merge().merge(root1, root2);
    }
}
