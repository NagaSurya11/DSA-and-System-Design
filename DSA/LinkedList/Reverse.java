package DSA.LinkedList;

public class Reverse {
    public Node iterative(Node head) {
        if(head == null) return null;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public Node recursive(Node prev, Node curr) {
        if(curr == null) return prev;
        Node temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
        return recursive(prev, curr);
    }
    public Node recursive(Node head) {
        if(head == null) return null;
        return recursive(null, head);
    }

    public Node reverse(Node head, int k) {
        Node prev = null;
        Node curr = head;
        if (curr == null) {
            return curr;
        }
        boolean isFirstTraversal = true;
        Node prevFirst = null;
        int count = 1;
        while (curr != null) {
            Node first = curr;
            prev = null;
            while (count++ <= k && curr != null) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            if(isFirstTraversal) {
                isFirstTraversal = false;
                head = prev;
            }else {
                prevFirst.next = prev;
            }
            count = 0;
            prevFirst = first;
        }
        return head;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        new Reverse().reverse(node, 2);
        // new Reverse().recursive(node);
    }
}
