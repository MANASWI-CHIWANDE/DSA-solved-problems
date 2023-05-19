package com.company.matrices;

import java.util.Arrays;

public class SetMatrixZero {
    /* BRUTEFROCE METHOD
    public static void set_matrix_zero_bruteForce(int matrix[][]){
        int rows = matrix.length;
        int column = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j =0;j<column;j++){
                if(matrix[i][j]==0){
                    int index = i+1;
                    while(index < rows){
                        if(matrix[index][j]!=0){
                            matrix[index][j]=-1;
                            index++;
                        }
                    }
                    index = i-1;
                    while(index >=0 ){
                        if(matrix[index][j]!=0){
                            matrix[index][j]=-1;
                            index--;
                        }
                    }
                    index = j+1;
                    while(index < column){
                        if(matrix[i][index]!=0){
                            matrix[i][index]=-1;
                            index++;
                        }
                    }
                    index = j-1;
                    while(index >=0){
                        if(matrix[i][index]!=0){
                            matrix[i][index]=-1;
                            index--;
                        }
                    }

                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j =0;j<column;j++){
                if(matrix[i][j]<0) {matrix[i][j]=0;}
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }*/
    /* BETTER method
    public static void set_matrix_zero_betterMethod(int [][]matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int dummy1[]= new int[rows];
        int dummy2[] = new int[columns];
        Arrays.fill(dummy1,-1);
        Arrays.fill(dummy2,-1);
        for(int i=0;i<rows;i++){
            for(int j =0;j<columns;j++) {
                if(matrix[i][j] == 0){
                    dummy1[i]=0;dummy2[j]=0;
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j =0;j<columns;j++) {
                if(dummy1[i]==0||dummy2[j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j =0;j<columns;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }*/
    public static void set_matrix_zero_bestMethod(int [][]matrix){
        int rows = matrix.length ,columns = matrix[0].length , col0 = 1;
        for(int i=0;i<rows;i++){
            if(matrix[i][0] ==0) col0=0;
            for(int j =1;j<columns;j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0]=0;matrix[0][j]=0;
                }
            }
        }
        for(int i = rows-1;i>=0;i--){
            for(int j = columns-1;j>=1;j--) {
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
            if(col0 ==0 )matrix[i][0]=0;
        }
        for (int[] ints : matrix) {
            for (int j = 0; j < columns; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }


    }
    public static void main(String[] args) {
        int matrix[][]={{1,1,1},{1,0,1},{1,1,1}};
        //set_matrix_zero_bruteForce(matrix);
        //set_matrix_zero_betterMethod(matrix);
        set_matrix_zero_bestMethod(matrix);
    }
}
