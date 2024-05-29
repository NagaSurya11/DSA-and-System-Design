package DSA.LinkedList;

public class Intersection {
    int getNoOfNodes(Node head) {
        int result = 0;
        Node curr = head;
        while (curr != null) {
            result++;
            curr = curr.next;
        }
        return result;
    }

    int intersectPoint(Node head1, Node head2, int n) {
        for (int i = 0; i < n; i++) {
            head1 = head1.next;
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }

    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        // code here
        Node curr1 = head1;
        Node curr2 = head2;
        int count1 = getNoOfNodes(curr1);
        int count2 = getNoOfNodes(curr2);
        if (count1 > count2) {
            return intersectPoint(curr1, curr2, count1 - count2);
        } else {
            return intersectPoint(curr2, curr1, count2 - count1);
        }
    }
}
