package DSA.Greedy;

public class Huffman {
    public static class Node {
        char c;
        int freq;
        Node left;
        Node right;
        public Node(char c, int freq, Node left, Node right) {
            this.c = c;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }
}
