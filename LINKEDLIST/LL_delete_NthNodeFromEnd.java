package com.company.linkedList;
//problem:https://leetcode.com/problems/remove-nth-node-from-end-of-list/
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class LL_delete_NthNodeFromEnd {
//    //time complexity : O(N) , Space Complexity = O(1)
//    static int countNodes(ListNode head){
//        ListNode temp=head;
//        int count =1;
//        while(temp.next!=null){
//            count++;
//            temp=temp.next;
//        }
//        return count;
//    }
//    static ListNode deleteNode(ListNode head,int pos){
//        ListNode temp=head;
//        ListNode prev = null;
//        if(head==null)return null;
//        if(pos==1 && head.next==null)return null;
//        else if(pos==1 && head.next!=null){
//            head=temp.next;
//            temp.next=null;
//            return head;
//        }
//        else{
//            while(pos>1){
//                prev = temp;
//                temp=  temp.next;
//                pos--;
//            }
//            if(temp.next==null){
//                prev.next=null;
//            }
//            else{
//                prev.next=temp.next;
//                temp.next=null;
//            }
//        }
//        return head;
//
//    }
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int count = countNodes(head)+1-n;
//        return deleteNode(head,count);
//    }

    //Time complexity=O(n), Space complexity = O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow= dummy;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow=slow.next.next;
        return dummy.next;
    }
}
