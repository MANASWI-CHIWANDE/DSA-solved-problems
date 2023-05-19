package com.company.linkedList;
//problem :https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it
/*
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list
such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.
 */
public class LL_sort_0_1_2 {
    static Node segregate(Node head)
    {
        int arr[]={0,0,0};
        Node temp=head;
        while(temp!=null){
            arr[temp.data]++;
            temp=temp.next;
        }
        temp = head;
        int i =0;
        while(temp!=null){
            if(arr[i]==0){
                i++;
            }
            else{
                temp.data=i;
                arr[i]--;
                temp=temp.next;
            }
        }
        return head;
    }
}
