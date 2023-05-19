package com.company.linkedList;
//problem : https://practice.geeksforgeeks.org/problems/introduction-to-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-doubly-linked-list
/*
Given an integer array arr of size n. Construct the doubly linked list from arr and return the head of it.
 */
class Node1{
    int data;
    Node1 next = null;
    Node1 prev = null;
    Node1(int x){
        data=x;
        next=null;
        prev=null;
    }
}
public class Introduction_toDoublyLinkedList {
    Node1 constructDLL(int arr[]) {
        Node1 currentNode = null;
        Node1 previousNode = null;
        Node1 head = new Node1(arr[0]);
        currentNode = head;
        for(int i =1;i<arr.length;i++){
            currentNode.next= new Node1(arr[i]);
            previousNode=currentNode;
            currentNode = currentNode.next;
            currentNode.prev = previousNode;
        }

        return head;
    }
}
