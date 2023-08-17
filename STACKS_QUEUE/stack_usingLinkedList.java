package com.company.stackAndQueue;
class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
public class stack_usingLinkedList {
    StackNode top;
    stack_usingLinkedList(){
        top=null;
    }


    //Function to push an integer into the stack.
    void push(int a)
    {
        StackNode node = new StackNode(a);
        node.next = top;
        top = node;
    }

    //Function to remove an item from top of the stack.
    int pop()
    {
        if (top == null) return -1;
        int topData = top.data;
        StackNode temp = top.next;

        top.next=null;
        top = temp;
        return topData;
    }
}
