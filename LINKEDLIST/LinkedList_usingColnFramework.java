package com.company.linkedList;
import java.util.*;
public class LinkedList_usingColnFramework {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.addFirst(2);
        list.addLast(6);
        System.out.println(list);
//        list.remove(0);
//        list.removeFirst();
//        list.removeLast();
//        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
}
