package DSA.LinkedList;

public class PairWiseSwap {
    // Function to swap elements pairwise.
    public static Node pairwise_swap(Node node) {
        // your code here
        Node prev = null;
        Node curr = node.next.next;
        Node head = node.next;
        head.next = node;
        prev = head.next;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            Node next = curr.next.next;
            curr.next.next = curr;
            prev = curr;
            curr = next;
        }
        if(curr != null) {
            prev.next = curr;
            prev = prev.next;
        }
        prev.next = null;

        return head;
    }

    public static void main(String[] args) {
        pairwise_swap(Mock.getNode());
    }
}
