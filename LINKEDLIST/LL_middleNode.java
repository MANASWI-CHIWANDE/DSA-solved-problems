package com.company.linkedList;
//problem : https://leetcode.com/problems/middle-of-the-linked-list/description/
/*
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
 */
public class LL_middleNode {
    /*//Navive Approach
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count =1;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        temp = head;
        for(int i =0;i<count/2;i++){
            temp=temp.next;
        }
        return temp;
    }*/

    //Better Approach
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null&&fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
