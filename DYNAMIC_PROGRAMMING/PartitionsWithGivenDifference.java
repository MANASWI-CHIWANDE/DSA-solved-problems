package com.company.dynamicProgramming;
/*
https://practice.geeksforgeeks.org/problems/partitions-with-given-difference/1
Given an array arr, partition it into two subsets(possibly empty) such that their union is the original array. Let the sum of the element of these two subsets be S1 and S2.

Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference S1 and S2 is equal to d. since the answer may be large return it modulo 109 + 7.

Example 1:

Input:
n = 4, d = 3
arr[] =  { 5, 2, 6, 4}
Output:
1
 */
public class PartitionsWithGivenDifference {
    //from file countSubset with sum = k ;
    final int mod =(int)1e9+7;
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
    public int countPartitions(int n, int d, int arr[]){
        // Code here
        // let subset s1 , s2 ; differnce =d

        /*
        totalSUm = sum of all ele of arrray
        given s1-s2=d
        then totalSum -s2-s2=d
        s2 = (totalSum -d)/2;
        therefoere our desired target = (totalSum -d)/2;
        with base conditions as s2 should be even and totalSum -d>=0
         */
        int totalSum =0;
        for(int ele :arr){
            totalSum+=ele;
        }
        ;
        if((totalSum-d) <0 || (totalSum-d)%2!=0 )return 0;
        int target = (totalSum-d)/2;
        return perfectSum(arr,n,target);
    }
}
