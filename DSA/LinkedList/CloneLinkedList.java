package DSA.LinkedList;

public class CloneLinkedList {
    public class Node {
        int data;
        Node next;
        Node random;
        Node(int data) {
            this.data = data;
        }
    }
    /**
     * @implNote each node has next and random reference
     */
    public Node copy_list(Node node) {
        Node curr;
        Node head1 = node;
        for(curr = node; curr != null ; curr = curr.next.next) { // copy of each node which has next only
            Node next = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = next;
        }
        for(curr = head1; curr != null; curr = curr.next.next) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
        }
        Node original = node;
        Node copy = node.next;
        Node result = copy;
        while (original != null) {
            original.next = original.next.next;
            copy.next = (copy.next == null) ? null: copy.next.next;
            original = original.next;
            copy = copy.next;
        }
        return result;
    }

    public static void main(String[] args) {
        CloneLinkedList x = new CloneLinkedList();
        Node start = x.new Node(1);
		start.next = x.new Node(2);
		start.next.next = x.new Node(3);
		start.next.next.next = x.new Node(4);
		start.next.next.next.next = x.new Node(5);

		// 1's random points to 3
		start.random = start.next.next;

		// 2's random points to 1
		start.next.random = start;

		// 3's and 4's random points to 5
		start.next.next.random = start.next.next.next.next;
		start.next.next.next.random
			= start.next.next.next.next;

		// 5's random points to 2
		start.next.next.next.next.random = start.next;

        x.copy_list(start);
    }
}
