package com.company.matrices;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> pascalsTriangle(int n){
        List<List<Integer>> pTriangle= new ArrayList<List<Integer>>();
        List<Integer> previousRow= null;
        List<Integer> currentRow = new ArrayList<Integer>();
        for(int i =0;i<=n;i++){
            for(int j =0;j<=i;j++){
                if(j==0 || j==i) currentRow.add(1);
                else currentRow.add(previousRow.get(j)+previousRow.get(j-1));
            }
            previousRow=currentRow;
            pTriangle.add(currentRow);
        }

        return pTriangle;
    }

    /*public static void pascalsTriangle(int n){
        int [][]matrix = new int[n][n];
        for(int i=0;i<n;i++){
            int j=0;
            while(j<=i){
                //matrix[i][j]=0;
                if(j==0)matrix[i][j]=1;
                else matrix[i][j]=matrix[i-1][j]+matrix[i-1][j-1];
                j++;
            }
        }
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }*/
    public static void main(String[] args) {
        int n = 5;
        pascalsTriangle(n);
    }
}
