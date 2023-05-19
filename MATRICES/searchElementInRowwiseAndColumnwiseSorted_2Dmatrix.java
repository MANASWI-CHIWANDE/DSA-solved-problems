package com.company.matrices;
/*
matrix = { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}};
question : rows and column of the matrix are sorted . Find if given target element is present in the matrix.
SOLUTION : For solving this question we will use DIVIDE AND CONQUER method.
1.we will put pointer on the last element of first row .
2.if target == ele the return position else
3. if target <ele , move to left of ele else down
4. repeat until target found
5. if array got out of bound then target not in matrix.
6. function will return arr with position of matrix

 */
public class searchElementInRowwiseAndColumnwiseSorted_2Dmatrix {
    public static boolean search2D(int[][] matrix, int target){
        boolean ans = false;
        int m = matrix.length;//# rows
        int n = matrix[0].length;//# columns
        int i = 0;// 1st row
        int j = n-1;// last column
        // we will iterate till we find the element and it will go out of bound when i>n & j<0
        while (i<m && j>=0){
            if(matrix[i][j] == target){
                System.out.println(target +" is found at ("+i+","+j+")");
                ans =true;
                break;
            }
            else{
                if(matrix[i][j]>target){
                    j--;//move left
                }
                else{
                    i++;//move down
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][] matrix = { {10, 20, 30, 40},
                            {15, 25, 35, 45},
                            {27, 29, 37, 48},
                            {32, 33, 39, 50} };
        /*int[] arr = search2D(matrix,25);
        for(int ele:arr){
            System.out.print(ele+" ");
        }*/
        System.out.println(search2D(matrix,39));
    }
}
