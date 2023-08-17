package com.company.dynamicProgramming;

import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/rod-cutting0840/1?page=1&sortBy=submissions
Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: Consider 1-based indexing.
Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and
6, i.e., 5+17=22.
 */
public class RodCutting {
    public int cutRod(int price[], int n) {
        //code here
        int[][]dp = new int[n][n+1];
        for(int[]arr:dp){
            Arrays.fill(arr,-1);
        }
        return recursion(price,n-1,n,dp);
    }
    public int tabulation(int price[], int n) {
        //code here
        int[]prev = new int[n+1];
        for(int i=0;i<=n;i++){
            prev[i]=i*price[0];
        }
        for(int index=1;index<n;index++){

            for(int target =0;target<=n;target++){
                int notTake = prev[target];
                int take = Integer.MIN_VALUE;
                int rodLength=index+1;
                if(rodLength<=target){
                    take = price[index]+prev[target-rodLength];
                }
                prev[target]= Math.max(notTake,take);
            }

        }
        return prev[n];
    }
    private int recursion(int price[], int index,int target,int[][]dp){

        if(index==0)return (int)(target)*price[0];
        if(dp[index][target]!=-1)return dp[index][target];
        int notTake = recursion(price, index-1, target,dp);
        int take = Integer.MIN_VALUE;
        if(index+1<=target){
            take = price[index]+recursion(price,index-1,target-index-1,dp);
        }
        return dp[index][target]= Math.max(notTake,take);
    }
}
