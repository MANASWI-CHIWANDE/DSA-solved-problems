package com.company.arrays;
import java.util.*;
//problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 */
public class Remove_Duplicates {
    public int removeDuplicates(int[] nums) {
        int k =0;int num=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            int value = map.getOrDefault(ele,0);
            map.put(ele,value+1);
            ele=0;
        }



        return k;
    }
}
