package com.company.linkedList;
//problem : https://practice.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=linked-list-insertion

/*
Your Task:
You only need to complete the functions insertAtBeginning() and insertAtEnd() that takes the head of link list and
 integer value of the data to be inserted as inputs and returns the head of the modified link list.
 */

public class LL_Insertion {
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {
        Node newNode  = new Node(x);
        newNode.next= head;
        return newNode;
    }

    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
        Node newNode  = new Node(x);
        if(head ==null){
            return newNode;
            // newNode.next= head;
        }
        else{
            Node temp = head;
            while(temp.next !=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }
}
