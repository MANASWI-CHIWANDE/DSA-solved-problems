package com.company.stackAndQueue;
import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
 */

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
class Pair{
    int first , second;
    Pair(int a ,int b){
        first =a;
        second=b;
    }
}
class withPair{
    private Stack<Pair> stack;
    public withPair() {
        stack= new Stack<>();
    }
    public void push(int val) {
        int min ;
        if(stack.isEmpty()){
            min=val;
        }
        else{
            min = Integer.min(val,stack.peek().second);
        }
        stack.push(new Pair(val,min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().first;
    }

    public int getMin() {
        return stack.peek().second;
    }
}

public class stack_minStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;
    public stack_minStack() {
        stack= new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(stack.isEmpty() || minStack.peek() > val){
            minStack.push(val);
        }
    }

    public void pop() {
        if(stack.peek()==minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
