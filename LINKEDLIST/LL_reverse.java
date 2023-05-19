package com.company.linkedList;
//problem :https://leetcode.com/problems/reverse-linked-list/
/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class LL_reverse {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode temp = null;

        while(head!=null){
            ListNode nextN = head.next;
            head.next=newHead;
            newHead = head;
            head = nextN;
        }
        return newHead;
    }
}
