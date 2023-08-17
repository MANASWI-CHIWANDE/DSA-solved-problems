package com.company.dynamicProgramming;

import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab
Given an array arr[] of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7

Example 1:

Input: N = 6, arr[] = {2, 3, 5, 6, 8, 10}
       sum = 10
Output: 3
Explanation: {2, 3, 5}, {2, 8}, {10}
 */
public class CountSubsetWithSum_k {
    static final int mod =(int)1e9+7;
    //tabulation
    public int perfectSum(int arr[],int n, int sum){
        int[]dp = new int[sum+1];
        if(arr[0]==0)dp[0]=2;
        else dp[0]=1;

        if(arr[0]!=0 && arr[0]<=sum)dp[arr[0]]=1;

        for(int i=1;i<n;i++){
            int[]temp = new int[sum+1];
            for(int target =0;target<=sum;target++){
                int notPick = dp[target];
                int pick =0;
                if(arr[i]<=target) pick = dp[target-arr[i]];
                temp[target]=(notPick+pick)%mod;
            }
            dp=temp;
        }
        return dp[sum];
    }
    private static int recursion(int num[],int index,int target,int[][]dp){
        if(index==0){
            if(target==0 && num[0]==0){
                return 2;
            }
            if(target==0 || num[0]==target){
                return 1;
            }
             return 0;
        }
        if(dp[index][target]!=-1)return dp[index][target];
        int notPick = recursion(num, index-1, target,dp);
        int pick =0;
        if(num[index]<=target) pick = recursion(num, index-1, target-num[index],dp);
        return dp[index][target]=(notPick+pick)%mod;
    }
    public static int findWays(int num[], int tar) {
        // Write your code here..
        int[][]dp = new int[num.length][tar+1];
        for(int[]arr:dp){
            Arrays.fill(arr,-1);
        }
        return recursion(num, num.length-1,tar,dp);
    }

    public static void main(String[] args) {
        int []num ={1,1,1};
        int tar=2;
        System.out.println();
    }
}
