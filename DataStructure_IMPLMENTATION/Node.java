package com.company.implementation;

public class Node {
    int data;
    Node next;
    Node(){
        this.data=0;
        this.next=null;
    }
    Node(int data){
        this.data = data;
        this.next=null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public int getData(){
        return data;
    }
}
