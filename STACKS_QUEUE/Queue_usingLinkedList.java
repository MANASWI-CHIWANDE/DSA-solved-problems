package com.company.stackAndQueue;
class QueueNode
{
    int data;
    QueueNode next;
    QueueNode(int a)
    {
        data = a;
        next = null;
    }
}
public class Queue_usingLinkedList {
    QueueNode front, rear;

    Queue_usingLinkedList() {
        front = null;
        rear = null;
    }

    //Function to push an element into the queue.
    void push(int a) {
        QueueNode newNode = new QueueNode(a);


        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    private boolean isEmpty() {
        return front == null;
    }

    //Function to pop front element from the queue.
    int pop() {
        if (isEmpty()) {
            return -1;
        }

        int removedData = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return removedData;

    }
}
