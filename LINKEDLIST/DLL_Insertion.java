package com.company.linkedList;
//problem:https://practice.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=insert-a-node-in-doubly-linked-list
/*
Given a doubly-linked list, a position p, and an integer x.
The task is to add a new node with value x at the position just after pth node in the doubly linked list.
 */
public class DLL_Insertion {
    void addNode(Node1 head_ref, int pos, int data) {
        if(head_ref == null){
            Node1 newNode = new Node1(data);
            newNode=head_ref;
        }
        else{
            Node1 current = head_ref;
            Node1 previous = null;
            for(int i=0;i<=pos;i++){
                previous=current;
                current = current.next;
            }
            Node1 newNode = new Node1(data);
            if(current==null){
                previous.next= newNode;
                newNode.prev= previous;
                newNode.next= null;
            }
            else{
                previous.next= newNode;
                newNode.prev= previous;
                newNode.next=current;
                current.prev= newNode;

            }

        }
    }
}
