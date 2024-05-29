package DSA.LinkedList;

public class SwapKthNode {
    Node swapkthnode(Node head, int num, int k) {
        // your code here
        if (k > num)
            return head;

        Node prevA = null;
        Node a = null;
        Node prevB = null;
        Node b = null;
        Node currHead = head;
        for (int i = 0; i < num; i++) {
            if (i == k - 2) prevA = head;
            if (i == k - 1) a = head;
            if (i == num - k - 1) prevB = head;
            if(i == num - k) b = head;
            head = head.next;
        }
        if(prevA != null) {
            prevA.next = b;
        }else {
            currHead = b;
        }

        if(prevB != null) {
            prevB.next = a;
        }else {
            currHead = a;
        }
        Node temp = a.next;
        a.next = b.next;
        b.next = temp;
        return currHead;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        // node.next.next.next.next = new Node(868);
        // node.next.next.next.next.next = new Node(63);
        new SwapKthNode().swapkthnode(node, 4, 3);
    }
}
