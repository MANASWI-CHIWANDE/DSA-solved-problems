package com.company.matrices;

/*Question :You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.*/
//Question link : https://leetcode.com/problems/search-a-2d-matrix/description/
public class search2D {
    /* first approach
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;
        int m=matrix.length;int n=matrix[0].length;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==target){
                    ans = true;
                }
                if(matrix[i][j]>target)break;
            }
        }
        return ans;
    }*/
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;//rows
        if(m==0)return false;
        int n=matrix[0].length;//column
        int start=0;
        int end = (m*n)-1;
        while(start<=end){
            int mid = (start+(end-start)/2);
            if( matrix[mid/n][mid%n] == target){
                System.out.println(target+" found at ("+mid/n+","+mid%n+")");
                return true;
            }
            if(target<matrix[mid/n][mid%n]){
                end=mid-1;
            }
            else {
                    start= mid+1;
                }
            }
        return false;
    }

    public static void main(String[] args) {
        int [][] matrix = { {10, 20, 30, 40},
                            {15, 25, 35, 45},
                            {27, 29, 37, 48},
                            {32, 33, 39, 50} };
        System.out.println(searchMatrix(matrix,25));
    }

}
