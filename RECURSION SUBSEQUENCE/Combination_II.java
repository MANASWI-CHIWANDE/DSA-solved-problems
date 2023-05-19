package com.company.recursion_subsequence;import java.util.*;
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
Input: candidates = [2,5,2,1,2], target = 5
Output: [[1,2,2],[5]]
 */
public class Combination_II {
    private void recursion(int[] arr, int target,int ind,List<List<Integer>> list,ArrayList<Integer> ds ){
        if(target==0){
            list.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=ind;i<arr.length;i++){
            if(i > ind && arr[i]==arr[i-1])continue;
            if(arr[i]>target)break;
            ds.add(arr[i]);
            recursion(arr,target-arr[i],i+1,list,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(candidates,target,0,list,new ArrayList<>());
        return list;
    }
}
