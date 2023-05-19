package com.company.linkedList;

import java.util.List;

//problem : https://leetcode.com/problems/reverse-linked-list-ii/description/
/*
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class LL_reverse_2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode previousNode = null;
        ListNode currentNode = head;
        if(head==null)return head;
        while(left>1){
            previousNode = currentNode;
            currentNode=currentNode.next;
            left--;
            right--;
        }
        ListNode connection = previousNode;
        ListNode tail = currentNode;
        while(right>0){
            ListNode next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }
        if(connection!=null){
            connection.next =previousNode;
        }
        else{
            head=previousNode;
        }
        tail.next= currentNode;
        return head;
    }
}
