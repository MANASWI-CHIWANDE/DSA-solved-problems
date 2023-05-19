package com.company.linkedList;

import java.util.ArrayList;
import java.util.HashMap;

public class LL_cloneWith_randomPointer {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //BRUTE FORCE APPROACH TC = O(N),SC = O(N)
//    public Node copyRandomList(Node head) {
//        if(head==null)return head;
////        if(head.next==null){
////            Node
////        }
//        Node temp = head;
//        HashMap<Node,Node> map = new HashMap<>();
//        //adding copied node to hashmap
//        while(temp!=null){
//            map.put(temp,new Node(temp.val));
//            temp = temp.next;
//        }
//        temp = head;
//        while(temp!=null){
//            Node node = map.get(temp);
//            node.next= (temp.next!=null)?map.get(temp.next):null;
//            node.random=(temp.random!=null)?map.get(temp.random):null;
//        }
//
//        return map.get(head);
//    }

    public Node copyRandomList(Node head){
        if(head==null)return head;
        Node temp = head;
        //inserting new node for linkelist
        while(temp!=null){
            Node newNode = new Node(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }
        //add random pointer
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random = temp.random.next;
            }
            temp=temp.next.next;
        }
        //seperating the linkedlist
        Node dummy = new Node(0);
        temp = dummy;
        Node itr = head;
        Node fast;
        while(itr!=null){
            fast = itr.next.next;
            temp.next=itr.next;
            itr.next=fast;
            temp=temp.next;
            itr=fast;
        }
        return dummy.next;
    }
}
