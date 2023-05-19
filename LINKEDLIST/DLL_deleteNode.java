package com.company.linkedList;
//problem :https://practice.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-node-in-doubly-linked-list
/*
Given a doubly linked list and a position. The task is to delete a node from given position in a doubly linked list.
 */

public class DLL_deleteNode {
    // function returns the head of the linkedlist
    Node1 deleteNode(Node1 head,int x)
    {
        if(x==1 && head.next==null){
            head = null;
        }
        else if(x==1 && head.next !=null){
            Node1 temp=head.next;
            head.next=null;temp.prev=null;head =temp;
        }
        else{
            Node1 curr = head;
            Node1 previous = null;
            for(int i=1;i<x;i++){
                previous=curr;
                curr = curr.next;
            }
            if(curr.next==null){
                previous.next= null;
                curr.prev = null;
            }
            else{
                previous.next=curr.next;
                curr.next.prev=previous;
                curr.prev=null;
                curr.next=null;
            }

        }
        return head;
    }
}
