package DSA.DoublyLinkedList;

public class InsertNode {
    void addNode(Node head, int pos, int data)
	{
		if(head == null) {
		    head = new Node(data);
		    return;
		}
		int i = 0;
		while(i++ < pos) {
		    head = head.next;
		}
		Node temp = new Node(data);
		temp.next = head.next;
		temp.prev = head;
		if(head.next != null) {
		    head.next.prev = temp;
		}
		head.next = temp;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
		new InsertNode().addNode(head, 2, 4);
	}
}
