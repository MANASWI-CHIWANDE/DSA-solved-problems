package com.company.linkedList;
import java.util.*;
//problem :https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 /*
 Given the heads of two singly linked-lists headA and headB, return the node
 at which the two lists intersect. If the two linked lists have no intersection at all, return null.
  */
public class LL_Y_Intersection {
    //Brute-force
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//        ListNode temp1=headA;
//        if(headA==null&&headB==null)return null;
//        while(temp1!=null){
//            ListNode temp2=headB;
//            while(temp2!=null){
//                if(temp1==temp2)return temp1;
//                temp2=temp2.next;
//            }
//            temp1=temp1.next;
//        }
//
//        return null;
//    }
    //USING HASHMAP
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        HashSet<ListNode> map = new HashSet<>();
//        ListNode temp= headA;
//        while(temp!=null){
//            map.add(temp);
//            temp=temp.next;
//        }
//        temp=headB;
//        while(temp!=null){
//            if(map.contains(temp))return temp;
//            else temp=temp.next;
//        }
//        return null;
//    }
      //BETTER OPTIMAL SOLUTION
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//        ListNode temp1=headA;int c1=1;
//        ListNode temp2=headB;int c2=1;
//        while(temp1.next!=null || temp2.next!=null){
//            if(temp1.next!=null){
//                c1++;temp1=temp1.next;
//            }
//            if(temp2.next!=null){
//                c2++;temp2=temp2.next;
//            }
//        }
//        temp1=headA;temp2=headB;
//        if(c1>c2){
//            while(c1!=c2){
//                c1--;
//                temp1=temp1.next;
//            }}
//        else if(c1<c2) {
//            while(c1!=c2){
//                c2--;
//                temp2=temp2.next;
//            }
//        }
//            while(temp1!=null&&temp2!=null){
//                if(temp1==temp2){
//                    return temp2;
//                }
//                else{
//                    temp1=temp1.next;
//                    temp2=temp2.next;
//                }
//            }
//            return null;
//    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode temp1=headA;
        ListNode temp2=headB;
        if(headA==null||headB==null)return null;
        while(temp1!=temp2){
            temp1 = temp1==null? headB:temp1.next;
            temp2 = temp2==null? headA:temp2.next;
        }
        return temp1;
    }
}
