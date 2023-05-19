package com.company.linkedList;
//problem:https://practice.geeksforgeeks.org/problems/find-length-of-loop/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-length-of-loop
/*
The task is to complete the function countNodesinLoop() which contains the only argument as reference
to head of linked list and return the length of the loop ( 0 if there is no loop).
 */
public class LL_countNodesInLoop {
    static int countNodes(Node n){
        int count =1;
        Node temp=n;
        while(temp.next!=n){
            temp=temp.next;
            count++;
        }
        return count;
    }
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        Node fast = head;
        Node slow = head;
        if(head==null || head.next==null) return 0;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast ==slow) {
                return countNodes(fast);
            }
        }
        return 0;
    }
}
