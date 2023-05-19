package com.company.arrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Array_List {
    public static void main(String[] args) {
        //Integer  | Float | String | Boolean |
        ArrayList<Integer> list = new ArrayList<Integer>();
        //add elements
        list.add(1);list.add(2);list.add(3);
        System.out.println(list);
        //get element
        int element = list.get(1);
        System.out.println(element);
        //add element in between
        list.add(0,0);
        System.out.println(list);
        //set element
        list.set(0,9);
        System.out.println(list);
        //delete element
        list.remove(3);
        System.out.println(list);
        //size
        System.out.println(list.size());
        //loops
        for(int i = 0 ;i < list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        //sorting
        Collections.sort(list);
        System.out.println(list);

    }
}
