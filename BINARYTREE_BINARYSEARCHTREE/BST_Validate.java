package com.company.binaryTree;
/*
https://leetcode.com/problems/validate-binary-search-tree/
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class BST_Validate {
    private boolean isValidBST(TreeNode root, long lowerBound, long upperBound){
        if(root==null)return true;
        if(root.val<=lowerBound || root.val >=upperBound)  return false;
        return isValidBST(root.left,lowerBound, root.val) && isValidBST(root.right, root.val, upperBound);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }
}
