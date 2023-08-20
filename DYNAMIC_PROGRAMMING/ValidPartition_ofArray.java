
/*
https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
You are given a 0-indexed integer array nums. You have to partition the array into one or more contiguous subarrays.

We call a partition of the array valid if each of the obtained subarrays satisfies one of the following conditions:

The subarray consists of exactly 2 equal elements. For example, the subarray [2,2] is good.
The subarray consists of exactly 3 equal elements. For example, the subarray [4,4,4] is good.
The subarray consists of exactly 3 consecutive increasing elements, that is, the difference between adjacent elements is 1. For example, the subarray [3,4,5] is good, but the subarray [1,3,5] is not.
Return true if the array has at least one valid partition. Otherwise, return false.
 */
public class ValidPartition_ofArray {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        if(nums[0]==nums[1])dp[2]=true;
        for(int i=2;i<n;i++){
            if(nums[i]==nums[i-1]){
                dp[i+1]|=dp[i-1];
            }
            if(nums[i]==nums[i-1] && nums[i-2]==nums[i-1]){
                dp[i+1]|=dp[i-2];
            }
            if(nums[i]==nums[i-1]+1 && nums[i]==nums[i-2]+2){
                dp[i+1]|=dp[i-2];
            }
        }
        return dp[n];
    }
}
