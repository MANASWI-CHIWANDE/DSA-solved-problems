package com.company.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array_6 {
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5};
        Integer[] arr2 = {1,2,3,7,8};
        Set<Integer> set1 = new HashSet<Integer>();
        set1.addAll(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<Integer>();
        set2.addAll(Arrays.asList(arr2));
        Set<Integer> union_set = new HashSet<Integer>(set1);
        union_set.addAll(set2);
        Set<Integer> intersection_set = new HashSet<Integer>(set1);
        intersection_set.retainAll(set2);
        System.out.println(union_set + "\t"+union_set.size());

        System.out.println(intersection_set+ "\t"+ intersection_set.size());
    }
}
