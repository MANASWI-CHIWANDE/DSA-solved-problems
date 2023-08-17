package com.company.dynamicProgramming;
/*
https://leetcode.com/problems/minimum-falling-path-sum/
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class MinimumFallingPathSum {
    private static int spaceOptimized(int[][] matrix){
        int row=matrix.length,col=matrix[0].length;
        int[] dp= new int[col];
        for(int i=0;i<col;i++){
            dp[i]=matrix[row-1][i];
        }

        for(int i=row-2;i>=0;i--){
            int[]temp = new int[col];
            for(int j=0;j<col;j++){
                int right = dp[j];
                int left = (j-1>=0)?dp[j-1]:Integer.MAX_VALUE;
                int diag = (j+1<col)?dp[j+1]:Integer.MAX_VALUE;
                temp[j]=matrix[i][j]+Math.min(right,Math.min(left,diag));
            }
            dp=temp;
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            ans=Math.min(ans,dp[i]);
        }
        return ans;
    }
   private static int tabualtion(int[][] matrix){
       int row=matrix.length,col=matrix[0].length;
       int[][] dp= new int[row][col];
       for(int i=0;i<col;i++){
           dp[row-1][i]=matrix[row-1][i];

       }

       for(int i=row-2;i>=0;i--){
           for(int j=0;j<col;j++){
               int right = dp[i+1][j];
               int left = (j-1>=0)?dp[i+1][j-1]:Integer.MAX_VALUE;
               int diag = (j+1<col)?dp[i+1][j+1]:Integer.MAX_VALUE;
               dp[i][j]=matrix[i][j]+Math.min(right,Math.min(left,diag));
           }
       }

       int ans = Integer.MAX_VALUE;
       for(int i=0;i<matrix[0].length;i++){
           ans=Math.min(ans,dp[0][i]);
       }
       return ans;
   }
    private static int recursion(int[][]dp,int[][] matrix,int i,int j,int row,int col){
        if(i<0 || j<0|| i>=row || j>=col)return (int)Math.pow(10,9);
        if(i==row-1 )return matrix[i][j];
        if(dp[i][j]!=-1)return dp[i][j];
        int down = matrix[i][j]+recursion(dp,matrix, i+1, j, row, col);
        int diag_left = matrix[i][j]+recursion(dp,matrix, i+1, j-1, row, col);
        int diag_right = matrix[i][j]+recursion(dp,matrix, i+1, j+1, row, col);
        return dp[i][j]=Math.min(down,Math.min(diag_left,diag_right));
    }
    public static int minFallingPathSum(int[][] matrix) {
        int ans =Integer.MAX_VALUE;
        int row=matrix.length,col=matrix[0].length;
        int[][] dp= new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            ans=Math.min(ans,recursion(dp,matrix,0,i,row , col));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][]mat ={{2,1,3},
                {6,5,4},
                {7,8,9}};
        //System.out.println(minFallingPathSum(mat));
        System.out.println(spaceOptimized(mat));
    }

}
