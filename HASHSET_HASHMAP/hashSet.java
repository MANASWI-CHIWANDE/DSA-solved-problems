package com.company.hashSet_hashMap;
import java.util.HashSet;
import java.util.Iterator;

public class hashSet {
    public static void main(String[] args) {
        //Creation of hashset
        HashSet<Integer> set = new HashSet<>();
        //insert
        set.add(1);set.add(2);set.add(3);set.add(1);
        //print all elements
        System.out.println(set);
        //print size of set
        System.out.println("The size of HashSet : "+ set.size());
        //to search
        if(set.contains(1)) System.out.println("set contains 1");
        if(!set.contains(6)) System.out.println("set doesnt contains 6");
        // to delete
        //set.remove(1);
        //System.out.println(set);
        //if(!set.contains(1)) System.out.println("we deleted 1");

        //ITERATOR
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
