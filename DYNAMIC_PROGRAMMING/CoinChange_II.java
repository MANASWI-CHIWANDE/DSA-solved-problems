package com.company.dynamicProgramming;

import java.util.Arrays;

/*
https://leetcode.com/problems/coin-change-ii/
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.



Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 */
public class CoinChange_II {
    private static int space_optimisation(int amount, int[] coins){
        int[] previous = new int[amount+1];
        int n = coins.length;
        for(int i=0;i<=amount;i++) {
            if (i % coins[0] == 0) previous[i] = 1;
        }
        for(int i=1;i<n;i++){
            int[] current = new int[amount+1];
            for(int amtTar=0;amtTar<=amount;amtTar++){
                int notpick = previous[amtTar];
                int pick =0;
                if(coins[i]<=amtTar){
                    pick = current[amtTar-coins[i]];
                }
                current[amtTar]=notpick+pick;
            }
            previous=current;
        }
        return previous[amount];
    }
    public static long tabulation(int target , int[] coins){
        long[][] dp = new long[coins.length][target+1];
        int n = coins.length;
        for(int i=0;i<=target;i++) {
            if (i % coins[0] == 0) dp[0][i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int amtTar=0;amtTar<=target;amtTar++){
                long notpick = dp[i-1][amtTar];
                long pick =0;
                if(coins[i]<=amtTar){
                    pick = dp[i][amtTar-coins[i]];
                }
                dp[i][amtTar]=notpick+pick;
            }

        }
        return dp[n-1][target];
    }
    public static int recursion(int target , int index,int[] coins,int[][] dp){
        if(index==0){
            if(target% coins[0]==0)return 1;
            else return 0;
        }
        if(target==0)return 1;
        if(dp[target][index]!=-1)return dp[target][index];
        int notpick = recursion(target,index-1,coins,dp);
        int pick =0;
        if(coins[index]<=target){
            pick = recursion(target-coins[index], index, coins,dp);
        }
        return dp[target][index] = notpick+pick;
    }
    public static int change(int amount, int[] coins) {
        int[][]dp= new int[amount+1][coins.length];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return recursion(amount, coins.length-1, coins,dp);
    }

    public static void main(String[] args) {
        int[] coins ={1,2,3};
        int amount = 4;
        //System.out.println(change(amount,coins));
        System.out.println(space_optimisation(amount,coins));
    }
}
