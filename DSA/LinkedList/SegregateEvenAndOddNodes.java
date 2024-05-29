package DSA.LinkedList;

public class SegregateEvenAndOddNodes {
    public Node segregate(Node head) {
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;

        Node curr = head;
        while (curr != null) {
            if(curr.data % 2 == 0) {
                if(evenStart == null) {
                    evenStart = curr;
                    evenEnd = curr;
                }else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            }else {
                if(oddStart == null) {
                    oddStart = curr;
                    oddEnd = curr;
                }else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
            curr = curr.next;
        }
        if(oddStart == null || evenStart == null) {
            return head;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = new SegregateEvenAndOddNodes().segregate(head);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
