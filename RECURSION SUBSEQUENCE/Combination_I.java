package com.company.recursion_subsequence;
import java.util.*;
/*
https://leetcode.com/problems/combination-sum/
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the
 chosen numbers sum to target. You may return the combinations in any order.
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
 */
public class Combination_I {
    private void recursion(int []arr,int target,int i,ArrayList<Integer>ds,List<List<Integer>> list){
        if(arr.length==i){
            if(target==0){
                list.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[i] < target) {
            ds.add(arr[i] );
            recursion(arr, target-arr[i], i, ds, list);
            ds.remove(ds.size()-1);
        }
        recursion(arr,target,i+1,ds,list);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(candidates,target,0, new ArrayList<>(),list);
        return list;
    }
}
