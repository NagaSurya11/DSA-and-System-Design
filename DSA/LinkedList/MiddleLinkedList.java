package DSA.LinkedList;

public class MiddleLinkedList {
    /**
     * @implNote 1 -> 2 -> 3 -> 4 -> 5 -> null
     * @param head
     * @return
     */
    Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        if(fast == null || fast.next == null) {
            return slow;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
