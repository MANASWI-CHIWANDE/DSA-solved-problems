package com.company.arrays;
import java.util.*;
//question : https://leetcode.com/problems/two-sum/description/
/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.*/

public class Two_Sum {
    /*//BRUTE-FORCE APPROACH
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        boolean bol = true;
        int i =0;
        while(bol){
            if(nums[i]+nums[i+1] == target) return new int[]{i,i+1};
            if(nums[i]+nums[i+1] > target) bol = false;
            i++;
        }
        return new int[] {};
    }*/
    /*//BETTER APPROACH
    public int[] twoSum(int[] nums, int target) {
        int arr[]= new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i< nums.length;i++){
            int neededNumber = target - nums[i];
            if(map.containsKey(neededNumber)){
                return new int[]{map.get(neededNumber),i};
            }
            map.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }*/
    //OPTIMAL APPROACH  - using two pointer approach for problem where we just have to tell target exist or not
    public boolean twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0;int right = n-1;
        while(left<right){
            if(nums[left]+nums[right] == target)return true;
            else if(nums[left]+nums[right] < target) left++;
            else right--;
        }
        return false;
    }
}
