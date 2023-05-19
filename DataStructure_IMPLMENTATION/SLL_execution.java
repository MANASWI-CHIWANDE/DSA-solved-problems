package com.company.implementation;

import com.company.implementation.SinglyLinkedList;

public class SLL_execution {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.append(10);
//        sll.print();
//        sll.append(20);
//        sll.print();
//        sll.append(30);
//        sll.print();
//        sll.prepend(11);
//        sll.print();
//        sll.insert(2,12);
//        sll.print();
//        sll.deleteNode(3);
//        sll.print();
        sll.append(55);
        sll.append(33);
        sll.append(22);
        sll.append(11);
        sll.append(44);
        sll.print();
        sll.bubbleSort();
        sll.print();

    }
}
