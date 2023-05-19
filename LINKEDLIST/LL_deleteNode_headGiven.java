package com.company.linkedList;
//problem : https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-a-node-in-single-linked-list
/*
Given a singly linked list and an integer x.Delete xth node from the singly linked list.
The function returns the head of the modified linked list.
 */
public class LL_deleteNode_headGiven {
    Node deleteNode(Node head, int x)
    {
        Node temp = head;

        if(x==1){
            head = temp.next;
            return head;
        }
        else{
            Node prevNode = null;
            for(int i =1;i<x;i++){
                prevNode = temp;
                temp = temp.next;

            }
            prevNode.next = temp.next;
            temp.next=null;
        }
        return head;

    }
}
