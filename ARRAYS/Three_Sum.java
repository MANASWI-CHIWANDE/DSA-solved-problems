package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//problem :https://leetcode.com/problems/3sum/
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
 */
public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i< nums.length-2;i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int left = i+1;
                int right= nums.length-1;
                int sum = 0-nums[i];
                while(left<right){
                    if(sum>nums[left]+nums[right])left++;
                    else if (sum<nums[left]+nums[right]) right--;
                    else{
                        ArrayList<Integer> arrlist = new ArrayList<>();
                        arrlist.add(nums[i]);
                        arrlist.add(nums[left]);
                        arrlist.add(nums[right]);
                        list.add(arrlist);
                        while(left<right&& nums[left+1]==nums[left])left++;
                        while(left<right && nums[right-1]==nums[right])right--;
                        left++;right--;
                    }
                }
            }
        }
        return list;
    }
}
