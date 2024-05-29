package DSA.BinarySearchTree;

public class Mock {
    public static Node getBSTree(int arr[]) {
        Node head = new Node(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            Node curr = head;
            Node prev = null;
            while (curr != null) {
                prev = curr;
                if(curr.data < arr[i]) {
                    curr = curr.right;
                }else {
                    curr = curr.left;
                }
            }
            if(prev.data < arr[i]) {
                prev.right = new Node(arr[i]);
            }else {
                prev.left = new Node(arr[i]);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = getBSTree(new int[]{15, 5, 20, 3, 13, 80, 16});
    }
}
