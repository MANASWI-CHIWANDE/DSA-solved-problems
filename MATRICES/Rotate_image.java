package com.company.matrices;

public class Rotate_image {
    /*public static void rotateImage(int [][] matrix){
        int n = matrix.length;
        int [][]rotatedMatrix = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                //rotatedMatrix[i][j]=matrix[j][n-i-1];//rotated 90degree anticlockwise
                rotatedMatrix[i][j]=matrix[n-j-1][i];//rotated 90degree clockwise
            }
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(rotatedMatrix[i][j]+ " ");
            }
            System.out.println();}
    }*/
    public static void rotateImage(int [][] matrix){
        int n = matrix.length;
        for(int i =0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]= matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
            System.out.println();}
    }
    public static void main(String[] args) {
        int image[][]={{1,2,3},{4,5,6},{7,8,9}};
        rotateImage(image);
    }
}
