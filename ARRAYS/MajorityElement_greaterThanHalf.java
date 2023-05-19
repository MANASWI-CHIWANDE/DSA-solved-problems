package com.company.arrays;
import java.util.*;
//question : https://leetcode.com/problems/majority-element/description/
public class MajorityElement_greaterThanHalf {
    /*//BRUTE APPROACH
    public int majorityElement(int[] nums) {
        int n= nums.length;

        for(int i =0;i<n;i++){
            int count = 0;
            for(int j =0;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>n/2) return nums[i];
        }
        return 0;
    }*/
    /*//BETTER APPROACH
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            int value = map.getOrDefault(ele,0);
            map.put(ele,value+1);
            if(map.get(ele)>(nums.length/2))return ele;
        }
        return 0;
    }*/
    //OPTIMAL APPROACH USIING MOORE'S VOTING SYSTEM
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = nums[0];int cnt=0;
        for(int i = 0;i<n;i++){
            if(nums[i]==ele) cnt++;
            else cnt--;
            if(cnt==0) ele = nums[i+1];
        }
        int count =0;
        for(int i =0 ;i<n;i++){
            if(nums[i]==ele) count++;
        }
        if(count>n/2) return ele;
        return 0;
    }
}


