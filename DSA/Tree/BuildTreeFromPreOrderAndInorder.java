package DSA.Tree;

import java.util.HashMap;

public class BuildTreeFromPreOrderAndInorder {
    HashMap<Integer, Integer> map = new HashMap<>();
    int preIdx = 0;

    /**
     *  int[] in = {20, 10, 40, 30, 50};
     *  int[] pre = {10, 20, 30, 40, 50};
     *                                                     buildTree(in, pre, 0, 4) preIdx = 0
     *                                                                   10
     *                   buildTree(in, pre, 0, 0)preIdx = 1                              buildTree(in, pre, 2, 4) preIdx = 2
     *                                  20                                                           30
     *                                                    buildTree(in, pre, 2, 2) preIdx = 3           buildTree(in, pre, 4, 4) preIdx = 4
     *                                                                  40                                          50
     */
    Node buildTree(int in[], int pre[], int start, int end) {
        if(start > end) return null;
        Node head = new Node(pre[preIdx++]);
        if(start == end) {
            return new Node(in[start]);
        }
        int inIdx = map.get(head.data);
        head.left = buildTree(in, pre, start, inIdx - 1);
        head.right = buildTree(in, pre, inIdx + 1, end);
        return head;
    }

    Node buildTreeFromInOrderAndPreOrder(int in[], int pre[]) {
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return buildTree(in, pre, 0, in.length - 1);
    }



    public static void main(String[] args) {
        int[] in = {40, 20, 50, 10, 30, 80, 70, 90};
        int[] pre = {10, 20, 40, 50, 30, 70, 80, 90};
        new LevelOrderTraversal().traverseAndPrintInDifferentLine(new BuildTreeFromPreOrderAndInorder().buildTreeFromInOrderAndPreOrder(in, pre));
    }
}
