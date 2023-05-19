package com.company.arrays;
import java.util.*;
// problem : https://leetcode.com/problems/4sum/
public class Four_Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lst = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if (nums == null || nums.length == 0)
            return lst;
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int left = j+1;
                int right = n-1;
                while(left<right){
                    if((long)nums[left] + (long)nums[right] == (long)target - (long)nums[i]-(long)nums[j]){
                        List<Integer> lst1 = new ArrayList<>();
                        lst1.add(nums[i] );
                        lst1.add(nums[j] );
                        lst1.add(nums[left] );
                        lst1.add(nums[right] );
                        lst.add(lst1);
                        while(left <right && lst1.get(2)== nums[left])  ++left;
                        while(left <right && lst1.get(3)== nums[right])right--;
                    }
                    else if(nums[left] + nums[right] < target - nums[i]-nums[j]) left ++;
                    else right--;
                }
                while(j<n-1 && nums[j]==nums[j+1]) ++j;
            }

            while(i<n-1 && nums[i]==nums[i+1]) ++i;
        }
        return lst;
    }
}
