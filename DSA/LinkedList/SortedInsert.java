package DSA.LinkedList;

public class SortedInsert {
    public void insert(Node head, int data) {
        Node temp = new Node(data);
        if(head == null) {
            head = temp;
            return;
        }
        Node curr = null;
        while (head.data < data && head.next != null) {
            curr = head;
            head = head.next;
        }
        temp.next = curr.next;
        curr.next = temp;
    }
}
