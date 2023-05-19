package com.company.linkedList;
//problem : https://leetcode.com/problems/linked-list-cycle/description/

public class LL_DetectLoop {
    /*
    //other technique time -O(n) space O(N);
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashset = new HashSet<>();
        while(head!=null){
            if(hashset.contains(head))return true;
            hashset.add(head);
            head = head.next;
        }
        return false;
    }
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head==null )return false;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)return true;
        }
        return  false;
    }

}
