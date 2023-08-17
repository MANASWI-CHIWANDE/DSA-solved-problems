package com.company.binaryTree;
/*
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 */
public class BST_constructFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i =new int[]{0};
        return bstFromPreorder(Integer.MAX_VALUE,preorder,i);
    }
    private TreeNode bstFromPreorder(int bound,int[] preorder,int[] i) {
        if( i[0]==preorder.length || preorder[i[0]]>bound )return null;
        TreeNode root= new TreeNode(preorder[i[0]++]);
        root.left = bstFromPreorder(root.val,preorder,i);
        root.right = bstFromPreorder(bound,preorder,i);
        return root;
    }
}
