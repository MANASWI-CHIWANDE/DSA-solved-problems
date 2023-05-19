package com.company.implementation;

public class SinglyLinkedList  {
    private Node head = null;
    private int length = 0;

    // returns head
    private Node getHead(){
        return head;
    }

    // traverses in a linked list
    private Node traverse(int index){
        Node current= head;
        for(int i = 2; i<= index ; i++) current = current.next;
        return current;
    }

    // prints the linked list
    public void print(){
        Node current = getHead();
        while(current.getNext()!=null){
            System.out.print("( " + current.getData() + "," + current.getNext() + " )  ->  ");
            current = current.getNext();
        }
        System.out.print("( " + current.getData() + "," + current.getNext() + " )   x  ");
        System.out.println();
    }

    // appends the node in linked list
    public int append(int data){
        if(head == null){
            head = new Node(data);
            length++;
            return 1;
        }
        else {
            Node lastNode = traverse(length);
            Node newNode = new Node(data);
            lastNode.setNext(newNode);
            length++;
            return 1;
        }
    }

    // prepends the node in linked list
    public int prepend(int data){
        if(head == null){
            head = new Node(data);
            length++;
            return  1;
        }
        else{
            Node newNode = new Node(data);
            newNode.setNext(head);
            head = newNode;
            length++;
            return 1;
        }
    }

    // insert node at a particular position
    public int insert(int position , int data){
        Node current = traverse(position);
        Node newNode = new Node(data);
        newNode.setNext(current);
        current = traverse(position-1);
        current.setNext(newNode);
        length++;
        return 1;
    }

    // deletes node at a particular position
    public int deleteNode(int position){
        //deletes first node
        if(position == 1){
            Node current = head;
            head = current.getNext();
            length--;
        }
        // deletes last node
        else if(position == length){
            Node current = traverse(length -1);
            current.setNext(null);
            length--;
        }
        // deletes node in between
        else{
            Node current = traverse(position -1);
            current.setNext(current.getNext().getNext());
            length--;
        }
        return 0;
    }

    // delete node with given data when same data is in many nodes
    public int deleteFirstNode(int data){
        if(head.getData() == data){
            Node current = head;
            head = current.getNext();
            length--;
            return 1;
        }
        else{
            Node current = head;
            while(current.getData() != data){
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            length--;
            return  1;
        }
    }

    // returns next node to given node
    Node deleteNextNode(Node cur){
        if(cur.getNext() == null){
            return cur;
        }
        else{
            cur.setNext(cur.getNext().getNext());
            return cur;
        }
    }

    //delete all node with given data when same data is in many nodes not yet completed ....
    public void deleteAllNode(int data){
        if(head.getData() == data){
            Node current = head;
            head = current.getNext();
            length--;
        }
        Node current = head;
        while(current.getNext()!= null){
            if(current.getData() == data){

            }
        }
    }

    // updates node data
    public void updateNode(int pos, int data){
        Node current = traverse(pos);
        current.setData(data);
    }

    // returns # nodes in linked list
    public void countNode(){
        System.out.println("# NODES IN LINKD LIST : " + length);
    }

    //perform bubble sort on linked list
    public void bubbleSort(){
        Node previous = getHead();
        Node current = null;
        int temp;
        if(head == null )return ;
        while(previous!=null){
            current = previous.getNext();
            while(current!=null){
                if(previous.getData()> current.getData()){
                    temp = previous.getData();
                    previous.setData(current.getData());
                    current.setData(temp);
                }
                current = current.getNext();
            }
            previous = previous.getNext();
        }

    }

    //create a loop in linkedlist at given position
    public void createCycle(Node head,int a,int b) {
        int cnta = 0,cntb = 0;
        Node p1 = getHead();
        Node p2 = getHead();
        while(cnta != a || cntb != b) {
            if(cnta != a)
            {p1 = p1.next; ++cnta;}
            if(cntb != b)
            {p2 = p2.next; ++cntb;}
        }
        p2.next = p1;
    }





}

