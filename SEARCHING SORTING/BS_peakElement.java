package com.company.SearchingAndSorting;
/*
https://leetcode.com/problems/find-peak-element/description/
162. Find Peak Element
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.
Example 1:   Input: nums = [1,2,3,1]  ,   Output: 2
 */
public class BS_peakElement {
    //time compleity O(log N)
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
//timee complexity O(N)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        else if(nums.length==2){
            if(nums[0]>nums[1])return 0;
            else return 1;
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(nums[0]>nums[1])return 0;
            }
            else if (i == nums.length-1){
                if(nums[nums.length-1]>nums[nums.length-2])return nums.length-1;

            }
            else  if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                return i;

            }
            else continue;
        }
        return -1;
    }
}
