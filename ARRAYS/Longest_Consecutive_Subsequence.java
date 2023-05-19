package com.company.arrays;
import  java.util.*;
//problem : https://leetcode.com/problems/longest-consecutive-sequence/description/
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
 */
public class Longest_Consecutive_Subsequence {
    /*BRUTE FORCE APPROACH
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int result=1;
        int currentCount=1;
        int previous = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]==previous+1) currentCount++;
            previous = nums[i];
            result = Math.max(result,currentCount);
        }

        return result;
    }*/
    //OPTIMAL APPROACH
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set = new HashSet<>();
        //adding element in set
        for(int ele : nums){
            set.add(ele);
        }
        int count=1;
        for(int ele : nums){
            if(!set.contains(ele-1)) {
                int currentElement = ele;
                int currentCount = 1;
                while (set.contains(currentElement + 1)) {
                    currentCount++;
                    currentElement++;
                }
                count = Math.max(count, currentCount);
            }
        }
        return count;
    }
}
