package com.company.linkedList;
//problem :https://practice.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=search-in-linked-list-1664434326
/*
Given a linked list of n nodes and a key , the task is to check if the key is present in the linked list or not.
 */
public class LL_searchElement {
    static boolean searchKey(int n, Node head, int key) {
        Node temp=head;
        for(int i =1;i<=n;i++){
            if(key== temp.data) return true;
            else{
                temp = temp.next;
            }
        }
        return false;
    }
}
