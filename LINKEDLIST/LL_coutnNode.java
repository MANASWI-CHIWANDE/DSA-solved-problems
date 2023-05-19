package com.company.linkedList;
//problem : https://practice.geeksforgeeks.org/problems/count-nodes-of-linked-list/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-nodes-of-linked-list
/*
Given a singly linked list. The task is to find the length of the linked list, where length is defined as the number of nodes in the linked list.
 */
public class LL_coutnNode {
    public static int getCount(Node head)
    {
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp= temp.next;

        }
        return count;
    }
}
