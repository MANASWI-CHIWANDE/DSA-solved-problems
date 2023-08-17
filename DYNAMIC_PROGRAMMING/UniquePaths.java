package com.company.dynamicProgramming;

import java.util.Arrays;

/*
https://leetcode.com/problems/unique-paths/description/
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths {
    private static int spaceOptimized(int m , int n){
        int[] prev = new int[n];
        for(int i =0;i<m;i++){
            int[] temp = new int[n];
            for(int j =0;j<n;j++){
                if(i==0 && j==0){
                    temp[j]=1;continue;
                }
                int a =0;int b=0;
                if(i>0) a = prev[j];
                if(j>0) b = temp[j-1];
                temp[j]=a+b;
            }
            prev=temp;
        }
        return prev[n-1];
    }
    private static int tabulation(int m , int n,int[][] dp){
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;continue;
                }
                int a =0;int b=0;
                if(i>0) a = dp[i-1][j];
                if(j>0) b = dp[i][j-1];
                dp[i][j]=a+b;
            }
        }
        return dp[m-1][n-1];
    }
    private static int recursion(int[][] dp,int row,int column,int i,int j){
        if(i==row-1 && j==column-1){
            return dp[i][j]=1;
        }
        if(i<0 || i>=row || j <0 || j>=column)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int a = recursion(dp,row,column,i,j+1);
        int b= recursion(dp,row, column, i+1, j);
        return dp[i][j]=a+b;

    }
    public static int uniquePaths(int m, int n) {
        int[][] dp  =new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return recursion(dp,m,n,0,0);
    }

    public static void main(String[] args) {
        int m=3,n=7;
        int[][] dp  =new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        //System.out.println(uniquePaths(m,n));
        System.out.println(tabulation(m,n,dp));
    }
}
