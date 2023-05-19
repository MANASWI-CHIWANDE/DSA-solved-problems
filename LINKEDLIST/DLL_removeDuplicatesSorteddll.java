package com.company.linkedList;
//problem:https://practice.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=remove-duplicates-from-a-sorted-doubly-linked-list
/*
Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked lis
n = 6    I/P: 1<->1<->1<->2<->3<->4
      Output: 1<->2<->3<->4
 */
public class DLL_removeDuplicatesSorteddll {
    static void deleteNode(Node1 head, Node1 deleteNode){
        if(head==null||deleteNode==null)return ;
        if(head==deleteNode)head=head.next;
        if(deleteNode.next!=null){
            deleteNode.next.prev=deleteNode.prev;
        }
        if(deleteNode.prev!=null){
            deleteNode.prev.next=deleteNode.next;
        }

    }
    Node1 removeDuplicates(Node1 head){
        if(head==null){
            return head;
        }
        Node1 temp = head;
        while(temp.next!=null){
            if(temp.data==temp.next.data){
                deleteNode(head,temp.next);
            }
            else temp = temp.next;
        }
        return head;
    }
}
