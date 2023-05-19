package com.company.linkedList;
//problem :https://leetcode.com/problems/linked-list-cycle-ii/description/
/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class LL_startingPt_ofLoop {
    //using extra space
//    public ListNode detectCycle(ListNode head) {
//
//        HashMap<ListNode,Integer> map = new HashMap<>();
//        ListNode temp=head;
//        if(head==null || head.next==null)return null;
//        while(temp.next!=null){
//            if(!map.containsKey(temp)){
//                map.put(temp,temp.val);
//            }
//            else{
//                return temp;
//            }
//            temp = temp.next;
//        }
//        return null;
//    }
//
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode fast=head,slow=head,entry=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)break;
        }
        while(slow!=entry){
            slow= slow.next;
            entry=entry.next;
        }
        return slow;
    }
}
