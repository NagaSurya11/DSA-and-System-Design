package DSA.LinkedList;

public class NthNodeFromLastWithoutN {
    int getNthFromLast(Node head, int n)
    {
    	// Your code here
        if(head == null) return -1;
        Node fast = head;
        for(int i = 0; i < n; i++) {
            if(fast == null) return -1;
            fast = fast.next;
        }
        Node slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
}
