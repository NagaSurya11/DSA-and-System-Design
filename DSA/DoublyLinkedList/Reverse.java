package DSA.DoublyLinkedList;

public class Reverse {
    public Node reverse(Node node) {
        if(node == null) return null;

        Node prev = null;
        Node curr = node;

        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }

        return prev.prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        new Reverse().reverse(head);
    }
}
