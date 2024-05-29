package DSA.LinkedList;

import java.util.HashMap;

class LRUCache {
    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;

            this.value = value;
        }
    }

    static int capacity, count;
    static HashMap<Integer, Node> map;
    static Node head;
    static Node tail;

    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int capacity) {
        // code here
        LRUCache.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public static void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        // your code here
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    // Function for storing key-value pair.
    public static void set(int key, int value) {
        // your code here
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

    public static void main(String[] args) {
        new LRUCache(2);
        LRUCache.set(4, 4);
        LRUCache.set(3, 3);
        LRUCache.set(2, 2);
        LRUCache.set(1, 1);
        System.out.println(LRUCache.get(1));
        System.out.println(LRUCache.get(2));
        System.out.println(LRUCache.get(3));
        System.out.println(LRUCache.get(4));
    }
}