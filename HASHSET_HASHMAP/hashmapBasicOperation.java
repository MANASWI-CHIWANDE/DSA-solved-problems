package com.company.hashSet_hashMap;

import java.util.*;

public class hashmapBasicOperation {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        //INSERTION OPERATION -> put()
        map.put("India",12);
        map.put("China",15);
        map.put("US",3);
        System.out.println(map);
        //SEARCH OPERATION
        if(map.containsKey("China")){
            System.out.println("pair exist");
        }
        else{
            System.out.println("Pair doesnt exist");
        }
        System.out.println(map.get("India"));
        //ITERATION IN HASHMAP
        for(Map.Entry<String,Integer> e: map.entrySet()){
            System.out.print(e.getKey()+" "+e.getValue());
            System.out.println();
        }
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key+" "+map.get(key));
        }
        //DELETION
        map.remove("China");
        System.out.println(map);

    }
}
