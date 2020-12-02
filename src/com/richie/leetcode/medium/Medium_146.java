package com.richie.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richie on 2020.12.01
 */
public class Medium_146 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
    }

    public static class LRUCache {
        private Map<Integer, Node> map;
        private Node head, tail;
        private int capacity;
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>((int) ((float) capacity / 0.75 + 1));
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                node = new Node(key, value);
                map.put(key, node);
                addToHead(node);
                if (++size > capacity) {
                    Node tail = removeTail();
                    map.remove(tail.key);
                    --size;
                }
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private Node removeTail() {
            Node prev = tail.prev;
            removeNode(prev);
            return prev;
        }

        public static class Node {
            int key, value;
            Node prev, next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

}
