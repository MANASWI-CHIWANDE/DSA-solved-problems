package com.company.linkedList;
//problem:https://practice.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list
/*
You are given the head of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key and return the new DLL.
Note :- There exists atleast 1 distinct element other than key.
Input:
2<->2<->10<->8<->4<->2<->5<->2
key = 2
Output:
10<->8<->4<->5
 */
public class DLL_deleteAllOccurencesOfX {
    static Node1 deleteAllOccurOfX(Node1 head, int x) {
        //if linkedList is empty
        if(head == null)return head;
        //if Linkedlist has only one node
        if(head.next==null){
            //if value of node ==key delete it
            if(head.data==x) return null;
            //else return head
            else return head;
        }
        Node1 temp = head;
        while (temp.next!=null){
            if(head.data==x){
                head=head.next;
                head.prev=null;
            }
            else if(temp.data==x){
                Node1 previousNode = temp.prev;
                Node1 nextNode = temp.next;
                previousNode.next=nextNode;
                nextNode.prev=previousNode;
            }
            temp=temp.next;
        }
        if(temp.data==x){
            Node1 lastNode = temp.prev;
            lastNode.next=null;
        }
        return head;
    }
}
