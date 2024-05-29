package DSA.LinkedList;

public class RemoveLoop {
    public static void removeLoop(Node head) {
        // code here
        // remove the loop without losing any nodes
        Node slow = head;
        Node fast = head;
        boolean isLoopDetected = false;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isLoopDetected = true;
                break;
            }
        }
        if(!isLoopDetected) return;
        if(fast == head && slow == head) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        }else {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        fast.next = null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head;
        removeLoop(head);
    }
}
