package DSA.Tree;

import java.util.HashMap;

public class BuildTreeFromPostOrderAndInOrder {
    HashMap<Integer, Integer> inOrderMap;
    int postIdx;
    Node buildTree(int in[], int post[], int start, int end) {
        if(start > end) return null;
        Node head = new Node(post[postIdx--]);
        if(start == end) {
            return new Node(in[start]);
        }
        int inIndex = inOrderMap.get(head.data);
        head.right = buildTree(in, post, inIndex + 1, end);
        head.left = buildTree(in, post, start, inIndex - 1);
        return head;
    }
    Node buildTree(int in[], int post[], int n) {
        inOrderMap = new HashMap<>();
        postIdx = n - 1;
        for(int i = 0; i < n; i++) {
            inOrderMap.put(in[i], i);
        }
        return buildTree(in, post, 0, n - 1);
    }

    public static void main(String[] args) {
        int n = 5,
        in[] = {9, 5, 2, 3, 4},
        post[] = {5, 9, 3, 4, 2};

        new LevelOrderTraversal().traverseAndPrintInDifferentLine(new BuildTreeFromPostOrderAndInOrder().buildTree(in, post, n));
    }
}
