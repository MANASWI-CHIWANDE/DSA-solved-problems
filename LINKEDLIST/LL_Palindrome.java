package com.company.linkedList;
//problem :https://leetcode.com/problems/palindrome-linked-list/
/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class LL_Palindrome {
    static ListNode reverse(ListNode n){
        ListNode prevNode = null;
        ListNode nextNode = n.next;
        while(n!=null){
            n.next=prevNode;
            prevNode=n;
            n=nextNode;
            nextNode=nextNode.next;
        }
        return prevNode;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow=head;
        if(head==null||head.next==null)return true;
        while(fast.next!=null&& fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;
        while(slow!=null){
            if(dummy.val!=slow.val)return false;
            slow=slow.next;
            dummy=dummy.next;
        }
        return true;

    }
}
