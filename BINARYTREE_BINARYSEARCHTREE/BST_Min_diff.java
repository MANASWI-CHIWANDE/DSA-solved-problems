package com.company.binaryTree;

/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
Example 1:
Input: root = [4,2,6,1,3]
Output: 1
Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
 */

public class BST_Min_diff {
    int mindiff;
    public int getMinimumDifference(TreeNode root) {
        mindiff=Integer.MAX_VALUE;
        inorder(root,Integer.MIN_VALUE);
        return  mindiff;
    }
    private int inorder(TreeNode root, int prev){
        if(root==null)return prev;
        prev = inorder(root.left,prev);
        if(prev!=Integer.MIN_VALUE){
            mindiff=Math.min(mindiff,root.val-prev);
        }
        prev =root.val;
        prev = inorder(root.right,prev);
        return prev;
    }
}
