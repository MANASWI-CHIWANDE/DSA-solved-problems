package com.company.linkedList;
//problem :https://leetcode.com/problems/add-two-numbers/
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class LL_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null &&l2==null)return null;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int sum=0;
            if(l1!=null){
                sum = sum+l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum =sum+l2.val;
                l2=l2.next;
            }
            if(carry>0){
                sum=sum+carry;
            }
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            temp.next=newNode;
            temp=temp.next;
        }
        return dummy.next;
    }
}
