package DSA.LinkedList;

public class Palindrome {
    Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    boolean isPalindrome(Node head) {
        // Your code here
        if (head == null || head.next == null) {
            return true;
        }
        if(head.next.next == null) {
            return head.data == head.next.data;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node rev = reverse(fast == null ? slow : slow.next);

        while (rev != null) {
            if (rev.data != head.data) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        new Palindrome().isPalindrome(Mock.getNode());
    }
}
