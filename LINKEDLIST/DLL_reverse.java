package com.company.linkedList;
//problem:https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-doubly-linked-list
/*
Given a doubly linked list of n elements. The task is to reverse the doubly linked list.
 */
public class DLL_reverse {
    public static Node1 reverseDLL(Node1  head)
    {
        Node1 temp=null;
        Node1 curr = head;
        while(curr!= null ){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next= temp;
            curr = curr.prev;
        }
        if(temp!=null){
            head=temp.prev;
        }
        return head;
    }

}
