package DSA.LinkedList;

public class Delete {
        //Function to delete a node without any reference to head pointer.
        void deleteNode(Node del_node)
        {
             // Your code her
             if(del_node == null || del_node.next == null) {
                 del_node = null;
                 return;
             }
             del_node.data = del_node.next.data;
             del_node.next = del_node.next.next;
        }

        void deleteFirstNode(Node head) {
            if(head == null || head.next == null) {
                head = null;
                return;
            }
            head.data = head.next.data;
            head.next = head.next.next;
        }
}
