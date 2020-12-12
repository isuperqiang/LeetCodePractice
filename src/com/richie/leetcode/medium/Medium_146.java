package com.richie.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richie on 2020.12.01
 */
public class Medium_146 {
    /**
     * LRU 缓存机制
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/lru-cache/
     * </p>
     *
     * <p>
     * 描述：
     * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
     * </p>
     *
     * <p>
     * 示例：
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     * 解释
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     * </p>
     *
     * <p>
     * 解答：
     * 双向链表+哈希表
     * </p>
     *
     * <p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
    }

    public static class LRUCache {
        private final Map<Integer, Node> map;
        private final DoubleLinkedList cache;
        private final int capacity;
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>((int) ((float) capacity / 0.75 + 1));
            cache = new DoubleLinkedList();
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            cache.moveToFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                cache.moveToFirst(node);
            } else {
                node = new Node(key, value);
                map.put(key, node);
                cache.addFirst(node);
                if (++size > capacity) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                    --size;
                }
            }
        }

        public static class DoubleLinkedList {
            private final Node head, tail;

            public DoubleLinkedList() {
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.next = head;
            }

            private void addFirst(Node node) {
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
            }

            private void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            private Node removeLast() {
                Node prev = tail.prev;
                remove(prev);
                return prev;
            }

            private void moveToFirst(Node node) {
                remove(node);
                addFirst(node);
            }
        }

        public static class Node {
            private int key, value;
            private Node prev, next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
