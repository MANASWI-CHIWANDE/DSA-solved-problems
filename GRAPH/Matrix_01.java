package com.company.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/01-matrix/
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 */
public class Matrix_01 {
    class Pair{
        int i_coordinate ;
        int j_coordinate ;
        int steps;
        Pair(int a , int b,int c){
            this.i_coordinate=a;
            this.j_coordinate=b;
            this.steps=c;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visitedArray = new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        int[][] distanceMat = new int[m][n];
        //finding cells with val==0
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    visitedArray[i][j]=true;
                }
            }
        }

        //delta row and delta column
        int[] drow={-1,1,0,0};
        int[] dcol = {0,0,1,-1};
        while(!q.isEmpty()){
            int i = q.peek().i_coordinate;
            int j = q.peek().j_coordinate;
            int steps = q.peek().steps;
            q.poll();
            distanceMat[i][j]=steps;
            for(int k =0 ;k<4;k++){
                int ni = i+drow[k];
                int nj = j+dcol[k];
                if(ni>=0 && ni<m && nj>=0 && nj<n && !visitedArray[ni][nj]){
                    q.offer(new Pair(ni,nj,steps+1));
                    visitedArray[ni][nj]=true;
                }
            }
        }
        return distanceMat;
    }
}
