package com.company.dynamicProgramming;

import com.company.AnonyOBJcontructor;

import java.util.Arrays;

/*
https://leetcode.com/problems/coin-change/description/
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    //recursion
    public int coinChange(int[] coins, int amount) {
        int ans = recursion(coins,amount , coins.length);
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
    private int recursion(int[] coins,int amount, int index){
        if(index==0){
            if(amount%coins[index]==0){
                return amount/coins[index];
            }
            else return Integer.MAX_VALUE;
        }
        int nottake = recursion(coins, amount, index-1);
        int take = Integer.MAX_VALUE;
        if(coins[index]<=amount) take = 1+recursion(coins, amount-coins[index], index);
        return Math.min(take, nottake);
    }
}
