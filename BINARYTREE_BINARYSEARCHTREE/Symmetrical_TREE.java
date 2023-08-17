package com.company.binaryTree;

//import com.sun.source.tree.Tree;

/*
https://leetcode.com/problems/symmetric-tree/
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class Symmetrical_TREE {
    private static boolean isSymetricUntil(TreeNode root1, TreeNode root2){
        if(root1==null&&root2==null)return root1==root2;
        return (root1.val== root2.val) && isSymetricUntil(root1.left,root2.right) && isSymetricUntil(root1.right,root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSymetricUntil(root.left,root.right);
    }
}
