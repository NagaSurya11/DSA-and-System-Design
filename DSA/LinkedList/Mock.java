package DSA.LinkedList;

public class Mock {
    static Node getNode() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(1);
        return head;
    }
}
