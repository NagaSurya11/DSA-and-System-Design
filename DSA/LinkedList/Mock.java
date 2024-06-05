package DSA.LinkedList;

public class Mock {
    public static Node getNode(int[] arr) {
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int  i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
}
