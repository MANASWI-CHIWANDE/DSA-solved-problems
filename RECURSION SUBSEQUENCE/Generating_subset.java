package com.company.recursion_subsequence;
import java.util.*;
public class Generating_subset {
    static void recursion(int start ,int[] nums,ArrayList<Integer> arrlist,List<List<Integer>> list){
        list.add(new ArrayList<>(arrlist));
        for(int i =start;i<nums.length;i++){
            arrlist.add(nums[i]);
            recursion(i+1,nums,arrlist,list);
            arrlist.remove(arrlist.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(0, nums,new ArrayList<>(),list);
        return list;
    }
}
