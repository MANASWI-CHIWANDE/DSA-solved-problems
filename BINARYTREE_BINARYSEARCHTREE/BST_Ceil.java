package com.company.binaryTree;
/*
https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
Given a BST and a number X, find Ceil of X.
Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.
 */
public class BST_Ceil {
    // Function to return the ceil of given number in BST.
    void foo(Node root, int key,int[] min){
        if (root == null) {
            return;
        } ;
        if(root.data>=key){
            min[0]=Math.min(min[0],root.data);
        }
        if(key>root.data){
            foo(root.right,key,min);
        }
        else  foo(root.left,key,min);
    }
    int findCeil(Node root, int key) {
        int[] min= new int[1];
        min[0]=Integer.MAX_VALUE;
        foo(root,key,min);
        if(min[0]==Integer.MAX_VALUE)min[0]=-1;
        return min[0];
        // Code here
    }
}
