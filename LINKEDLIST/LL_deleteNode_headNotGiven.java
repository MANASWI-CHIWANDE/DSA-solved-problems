package com.company.linkedList;
//problem : https://leetcode.com/problems/delete-node-in-a-linked-list/description/


public class LL_deleteNode_headNotGiven {
    public void deleteNode(ListNode node) {
        node.val =node.next.val;
        node.next= node.next.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
