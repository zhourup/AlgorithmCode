package main.java.hot100;

import java.util.HashMap;
import java.util.Map;

public class Hot146 {

    static class LRUCache {
        class Node {
            int key;
            int val;
            Node prev;
            Node next;

            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        //存储节点
        Map<Integer, Node> cache;
        Node head, tail;
        int capacity;
        int size;

        public LRUCache(int capacity) {
            cache = new HashMap<>(capacity);
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            size = 0;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            //将该节点移至末尾
            moveToTail(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = value;
                moveToTail(node);
            } else {
                Node newNode = new Node(key, value);
                if (size >= capacity) {
                    cache.remove(head.next.key);
                    removeHead();
                    size--;
                }
                cache.put(key, newNode);
                addToTail(newNode);
                size++;
            }
        }

        private void moveToTail(Node node) {
            deleteNode(node);
            addToTail(node);
        }

        private void deleteNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToTail(Node node) {
            node.prev = tail.prev;
            tail.prev.next = node;
            node.next = tail;
            tail.prev = node;
        }

        private void removeHead() {
            deleteNode(head.next);
        }
    }


    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
    }
}
