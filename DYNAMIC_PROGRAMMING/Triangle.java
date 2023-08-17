package com.company.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/triangle/
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.



Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 */
public class Triangle {
    private int memoRecursion(int i, int j,List<List<Integer>> triangle,int[][]dp){
        if(dp[i][j]!=-1)return dp[i][j];
        if(i== triangle.size()-1)return triangle.get(i).get(j);

        int down = triangle.get(i).get(j) + memoRecursion(i+1,j,triangle,dp);
        int diagonal =triangle.get(i).get(j)+memoRecursion(i+1,j+1,triangle,dp);
        return dp[i][j]=Math.min(down,diagonal);
    }
    private int tabulation(List<List<Integer>> triangle){
        int n= triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = triangle.get(i).get(j)+dp[i+1][j];
                int diagonal = triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(down,diagonal);
            }
        }
        return dp[0][0];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp=new int[n][n];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return memoRecursion(0,0,triangle,dp);
    }
}
