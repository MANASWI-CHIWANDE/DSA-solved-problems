package com.company.arrays;
//problem : https://leetcode.com/problems/max-consecutive-ones/
public class Max_consecutive_ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            int count =0;
            if(nums[i] ==1){
                count++;
            }
            while(i< nums.length && nums[i]==0&&nums[i]==nums[i+1]){
                count++;i++;
            }
            max= Math.max(max,count);
        }
        return max;
    }
}
