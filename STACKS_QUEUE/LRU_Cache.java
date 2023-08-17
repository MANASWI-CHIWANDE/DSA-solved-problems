package com.company.stackAndQueue;

import java.util.HashMap;

/*
https://leetcode.com/problems/lru-cache/description/
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
 */

public class LRU_Cache {
    class LRU_Node{
        int key,val;
        LRU_Node next;
        LRU_Node prev;
        LRU_Node(int key,int val){
            this.key=key;
            this.val=val;
            next=null;
            prev=null;
        }
    }
    int capacity;
    HashMap<Integer,LRU_Node> map = new HashMap<>();
    LRU_Node head = new LRU_Node(0,0);
    LRU_Node tail= new LRU_Node(0,0);

    public LRU_Cache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            LRU_Node node = map.get(key);
            delete(node);
            insert(node);
            return node.val;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            delete(map.get(key));
        }
        else{
            if(map.size()==capacity){
                delete(tail.prev);
            }
        }
        insert(new LRU_Node(key,value));
    }

    private void delete(LRU_Node node){
        map.remove(node.key);
        LRU_Node prevNode = node.prev;
        LRU_Node nextNode = node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }

    private void insert(LRU_Node node){
        map.put(node.key,node);
        LRU_Node nextNode = head.next;
        head.next=node;
        node.prev=head;
        node.next=nextNode;
        nextNode.prev = node;
    }
}
