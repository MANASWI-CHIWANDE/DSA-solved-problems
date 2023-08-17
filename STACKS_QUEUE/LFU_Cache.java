package com.company.stackAndQueue;

import java.util.HashMap;

public class LFU_Cache {
    private int capacity;
    private int size;
    private int minFrequency;
    private HashMap<Integer, Node> keyToNode;
    private HashMap<Integer, DoublyLinkedList> freqToLinkedList;

    class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node node) {
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node firstNode = head.next;
            removeNode(firstNode);
            return firstNode;
        }

        public int getSize() {
            return size;
        }
    }

    public LFU_Cache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFrequency = 0;
        this.keyToNode = new HashMap<>();
        this.freqToLinkedList = new HashMap<>();
    }

    public int get(int key) {
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            updateNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if (size == capacity) {
                DoublyLinkedList minFreqList = freqToLinkedList.get(minFrequency);
                Node nodeToRemove = minFreqList.removeFirst();
                keyToNode.remove(nodeToRemove.key);
                size--;
            }
            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            DoublyLinkedList newList = freqToLinkedList.getOrDefault(1, new DoublyLinkedList());
            newList.addNode(newNode);
            freqToLinkedList.put(1, newList);
            minFrequency = 1;
            size++;
        }
    }

    private void updateNode(Node node) {
        int frequency = node.frequency;
        DoublyLinkedList oldList = freqToLinkedList.get(frequency);
        oldList.removeNode(node);

        if (frequency == minFrequency && oldList.getSize() == 0) {
            minFrequency++;
        }

        node.frequency++;
        DoublyLinkedList newList = freqToLinkedList.getOrDefault(node.frequency, new DoublyLinkedList());
        newList.addNode(node);
        freqToLinkedList.put(node.frequency, newList);
    }
}
