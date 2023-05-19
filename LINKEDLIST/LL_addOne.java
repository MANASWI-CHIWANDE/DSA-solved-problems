package com.company.linkedList;
//problem :https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-1-to-a-number-represented-as-linked-list
/*
A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.
LinkedList: 4->5->6       ,           Output: 457
 */
public class LL_addOne {
    static Node reverse(Node head){
        Node prev = null;
        Node temp = head;
        while(temp!=null){
            Node nextNode = temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }
        if(prev!=null){
            head=prev;
            return head;
        }
        return null;
    }
    public static Node addOne(Node head){
        Node newHead = reverse(head);
        Node temp = newHead;
        int carry =0;
        while(temp!=null){
            if(temp.data<9){
                temp.data= temp.data+1;
                break;
            }
            if(temp.data==9){
                temp.data=0;
                carry=1;
                if(temp.next==null){
                    Node newNode =new Node(1);
                    temp.next = newNode;
                    newNode.next=null;
                    break;
                }
            }
            temp=temp.next;
        }

        return reverse(newHead);
    }
}
