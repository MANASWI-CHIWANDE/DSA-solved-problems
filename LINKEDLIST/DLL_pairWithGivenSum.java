package com.company.linkedList;
import java.util.*;
//problem:https://practice.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-pairs-with-given-sum-in-doubly-linked-list
/*
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.
Input:  1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9   ,   target = 7
Output: (1, 6), (2,5)
 */
public class DLL_pairWithGivenSum {
    //time Complexity =O(N^2) , Space Complexity =O(1)
    //    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node1 head) {
//        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
//        Node1 temp = head;
//        while(temp.next!=null){
//            Node1 nextNode = temp.next;
//            while(nextNode.next!=null){
//                if(temp.data+nextNode.data==target){
//                    ArrayList<Integer> arr1 = new ArrayList<>();
//                    arr1.add(temp.data);arr1.add(nextNode.data);
//                    arr.add(arr1);
//                }
//                nextNode=nextNode.next;
//            }
//            temp=temp.next;
//        }
//        return arr;
//    }
    //Time Complexity =O(N), Space Complexity =O(1)
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node1 head) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Node1 left = head;
        Node1 right = head;
        //move right pointer to end of linked list
        while(right.next!=null){
            right=right.next;
        }
        while(left.data<right.data){
            if(right.data+ left.data>target){
                right=right.prev;
            }
            else if(right.data+ left.data<target){
                left=left.next;
            }
            else{
                ArrayList<Integer> arr1 = new ArrayList<>();
                arr1.add(left.data);arr1.add(right.data);
                arr.add(arr1);
                right=right.prev;
                left=left.next;
            }
        }
        return arr;
    }

}
