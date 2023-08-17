package com.company.binaryTree;
import java.util.Arrays;
/*
https://leetcode.com/problems/unique-binary-search-trees/description/
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 */
public class BST_uniqueBst_I {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return func_memo(n,dp);
    }
    private int func_memo(int n,int[]dp){
        if(n<=1)return 0;
        if(dp[n]!=-1)return dp[n];
        int ans=0;
        for(int i=1;i<=n;i++){
            ans+=func_memo(i-1,dp)*func_memo(n-i,dp);
        }
        return dp[n]=ans;
    }
}
