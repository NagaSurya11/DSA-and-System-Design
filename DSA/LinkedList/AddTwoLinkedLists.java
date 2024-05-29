package DSA.LinkedList;

import java.util.Stack;

public class AddTwoLinkedLists {
    // Function to add two numbers represented by linked list.
    // static void pushAllElementsInsideStack(Node node, Stack<Integer> stack) {
    // while (node != null) {
    // stack.push(node.data);
    // node = node.next;
    // }
    // }

    // static Node addTwoStacks(Stack<Integer> s, Stack<Integer> g) {
    // int carry = 0;
    // Node node = null;
    // while (!s.isEmpty()) {
    // int x = s.pop();
    // int y = g.pop();

    // int sum = x + y + carry;
    // int data = sum % 10;
    // carry = sum / 10;

    // Node temp = new Node(data);
    // temp.next = node;
    // node = temp;
    // }

    // while (!g.isEmpty()) {
    // int sum = g.pop() + carry;
    // int data = sum % 10;
    // carry = sum / 10;
    // Node temp = new Node(data);
    // temp.next = node;
    // node = temp;
    // }
    // while (carry > 0) {
    // int data = carry % 10;
    // carry = carry / 10;
    // Node temp = new Node(data);
    // temp.next = node;
    // node = temp;
    // }

    // while (node != null && node.data == 0 && node.next != null) {
    // node = node.next;
    // }
    // return node;
    // }

    // /**
    // * @TC = O(n + m)
    // * @SC = O(max(m, n))
    // * @param num1
    // * @param num2
    // * @return
    // */
    // static Node addTwoLists(Node num1, Node num2) {
    // // code here
    // // return head of sum list
    // Stack<Integer> stack1 = new Stack<>();
    // Stack<Integer> stack2 = new Stack<>();

    // pushAllElementsInsideStack(num1, stack1);
    // pushAllElementsInsideStack(num2, stack2);

    // if (stack1.size() > stack2.size()) {
    // return addTwoStacks(stack2, stack1);
    // } else {
    // return addTwoStacks(stack1, stack2);
    // }

    // }

    static Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * @TC = O(n + m)
     * @SC = O(1)
     * @param num1
     * @param num2
     * @return
     */
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
        num1 = reverse(num1);
        num2 = reverse(num2);
        int carry = 0;
        Node result = null;
        while (num1 != null || num2 != null || carry > 0) {
            int sum = carry;
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
            carry = sum / 10;
            Node temp = new Node(sum % 10);
            temp.next = result;
            result = temp;
        }
        // remove trailing zeros
        while (result != null && result.next != null && result.data == 0) {
            result = result.next;
        }
        return result;
    }
}
