package oj.leetcode;

import java.util.HashMap;

/**
 * 146. LRU Cache
 * 要实现LRU的功能需要一个链表维护最近访问的元素,但是Map.remove的时间复杂度并非O(1)????
 * Created by vonzhou on 2019/2/17.
 */
public class LRUCache {

    HashMap<Integer, Node> map;
    int capacity, count;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;

            // 最近访问的,移动到链表头部
            moveToHead(node);

            return result;
        }
        return -1;
    }


    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                // 否则删掉最不常访问的元素节点
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private void moveToHead(Node node) {
        deleteNode(node);
        addToHead(node);
    }


    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}