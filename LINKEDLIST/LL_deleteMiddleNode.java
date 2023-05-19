package com.company.linkedList;
//problem :https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
/*
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */
public class LL_deleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {

        if(head.next==null)return  null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp=null;
        while(fast!=null&&fast.next !=null){
            fast = fast.next.next;
            temp=slow;
            slow = slow.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}
