package com.company.recursion_subsequence;
import java.util.*;
/*
https://leetcode.com/problems/subsets-ii/
Given an integer array nums that may contain duplicates, return all possible subsets(the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class Subsets_II {
    private void recursion(int[] arr,int i,List<List<Integer>> ans,ArrayList<Integer>ds){
        if(i==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[i]);
        recursion(arr,i+1,ans,ds);
        ds.remove(ds.size()-1);
        recursion(arr,i+1,ans,ds);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(nums,0,ans,new ArrayList<>());
        return ans;
    }
}
