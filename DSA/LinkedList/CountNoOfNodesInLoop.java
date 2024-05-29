package DSA.LinkedList;

public class CountNoOfNodesInLoop {
    int countNoOfNodesInLoop(Node head) {
        Node slow = head.next;
        if(slow == null) return 0;
        Node fast = head.next.next;

        while (slow != fast) {
            if(slow == null) return 0;
            slow = slow.next;
            if(fast == null || fast.next == null) return 0;
            fast = fast.next.next;
        }
        int count = 0;
        do {
            slow = slow.next;
            count++;
        }while(slow != fast);

        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;

        new CountNoOfNodesInLoop().countNoOfNodesInLoop(head);

    }
}
