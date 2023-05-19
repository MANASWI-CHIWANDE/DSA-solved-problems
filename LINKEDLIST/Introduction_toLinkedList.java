package com.company.linkedList;
//question : https://practice.geeksforgeeks.org/problems/introduction-to-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-linked-list

/*
Your Task:
You don't need to read input or print anything.
Your task is to complete the function constructLL() which takes arr[] as input parameters and returns the head of the Linked List.
 */

class Node {
    int data;
    Node next;

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
}

public class Introduction_toLinkedList {
    static Node constructLL(int arr[]) {
        Node firstNode= new Node(arr[0]);
        Node temp = firstNode;
        for(int i =1;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return firstNode;

    }
}
