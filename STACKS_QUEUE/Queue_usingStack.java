package com.company.stackAndQueue;
import java.util.*;
//uisng two stacks
public class Queue_usingStack {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public Queue_usingStack() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if (outputStack.isEmpty()) {
            transferElements();
        }
        return outputStack.pop();
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            transferElements();
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void transferElements() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }
}
