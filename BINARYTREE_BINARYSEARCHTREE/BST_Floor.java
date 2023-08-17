package com.company.binaryTree;
/*
https://practice.geeksforgeeks.org/problems/floor-in-bst/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-bst
You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
Note: when x is smaller than the smallest node of BST then returns -1.
 */
public class BST_Floor {
    private static void foo(Node root, int x,int[]max){
        if(root==null)return ;
        if(root.data<=x){
            max[0]=Math.max(max[0],root.data);
        }
        if(root.data>x){
            foo(root.left,x,max);
        }
        else{
            foo(root.right,x,max);
        }
    }
    public static int floor(Node root, int x) {
        // Code here
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        foo(root,x,max);
        if(max[0]==Integer.MIN_VALUE)max[0]=-1;
        return max[0];
    }
}
