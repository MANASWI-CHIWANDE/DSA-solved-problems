package com.company.linkedList;

public class LL_Rotate {
    // brute - force method
//    public ListNode rotateRight(ListNode head, int k) {
//        if(head==null|| head.next==null)return head;
//        while(k>0){
//            ListNode prev = null;
//            ListNode curr = head;
//            while(curr.next!=null){
//                prev = curr;
//                curr=curr.next;
//            }
//            prev.next=null;
//            curr.next=head;
//            head=curr;
//            k--;
//        }
//        return head;
//    }

    public ListNode rotateRight(ListNode head, int k){
        ListNode temp= head;
        int count=1;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        temp.next = head;
        int pos = count - (k%count);
        ListNode curr =head;
        ListNode prev = null;
        for(int i =0;i<pos;i++){
            prev.next = curr;
            curr=curr.next;
        }
        prev.next=null;
        head = curr;
        return head;
    }

}
