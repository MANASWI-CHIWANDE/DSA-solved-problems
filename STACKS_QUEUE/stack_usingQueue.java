package com.company.stackAndQueue;
import java.util.*;
/*
https://leetcode.com/problems/implement-stack-using-queues/
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 */

//USING TWO QUEUES
/*


public class stack_usingQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public stack_usingQueue() {
        queue1= new LinkedList<>();
        queue2= new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while(!queue1.isEmpty()){
            queue2.add(queue1.remove());
            queue1.remove();
        }
        swapQueues(queue1,queue2);
    }
    private static void swapQueues(Queue<Integer> queue1, Queue<Integer> queue2) {
        Queue<Integer> tempQueue = new LinkedList<>(queue1);
        queue1.clear();
        queue1.addAll(queue2);
        queue2.clear();
        queue2.addAll(tempQueue);
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}*/
public class stack_usingQueue{
    private Queue<Integer> q;
    public stack_usingQueue(){
        q=new LinkedList<>();
    }
    public void push(int x){
        q.add(x);
        for(int i =0;i<q.size()-1;i++){
            q.add(q.remove());
        }
    }
    public int pop(){
       return q.remove();
    }
    public int top(){
        return q.peek();
    }
}
