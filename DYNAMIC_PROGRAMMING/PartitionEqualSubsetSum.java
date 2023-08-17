package com.company.dynamicProgramming;
/*
https://leetcode.com/problems/partition-equal-subset-sum/
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 */
public class PartitionEqualSubsetSum {
//    private static boolean tabulation(int n, int target, int arr[]){
//        boolean[][]dp = new boolean[n][target+1];
//        for(int i=0;i<n;i++){
//            dp[i][0]=true;
//        }
//        if(arr[0]<=target) dp[0][arr[0]]=true;
//        for(int i=1;i<n;i++){
//            for(int j=1;j<=target;j++){
//                boolean notpick = dp[i-1][j];
//                boolean pick=false;
//                if(arr[i]<=j){
//                    pick = dp[i-1][j-arr[i]];
//                }
//                dp[i][j]= notpick || pick;
//            }
//        }
//        return dp[n-1][target];
//    }
    private static boolean tabulation(int[]nums,int target){
        int n= nums.length;
        //boolean[][] dp = new boolean[n][target+1];
        boolean[] prev = new boolean[target+1];
        for(int i=0;i<n;i++){
            prev[0]=true;
        }
        if(nums[0]<=target)prev[nums[0]]=true;
        for(int i=1;i<n;i++){
            boolean[] curr = new boolean[target+1];
            for(int tar =1;tar<=target;tar++){
                boolean notpick  = prev[tar];
                boolean pick =false;
                if(nums[i]<= tar){
                    pick=prev[tar-nums[i]];
                }
                curr[tar] = notpick||pick;
            }
            prev=curr;
        }
        return prev[target];
    }
    private static boolean recursion(int[]nums,int target,int ind){
        if(target==0)return true;
        if(ind==0)return nums[0]==target;
        boolean notpick= recursion(nums, target, ind-1);
        boolean pick = true;
        if(nums[ind]<=target){
            pick= recursion(nums, target-nums[ind], ind-1);
        }
        return notpick||pick;
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2==1)return false;
        else{
            //return recursion(nums,sum/2, nums.length-1);
            return tabulation(nums,sum/2);
        }

    }

    public static void main(String[] args) {
        int[] nums={2,3,1,4};

        if(canPartition(nums)){
            System.out.println("can be partioitoned");
        }
        else{
            System.out.println("cant be ");
        }
    }
}
