package com.company.binaryTree;
/*
 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 */
public class BST_constructFromSortedArray {
    private TreeNode foo(int[]nums,int start , int end){
        if(end<start )return null;
        int length= end-start+1;
        int iroot = (end+start)/2;
        TreeNode node = new TreeNode(nums[iroot]);
        node.left = foo(nums,start,iroot-1);
        node.right= foo(nums,iroot+1,end);
        return node;

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return foo(nums,0,nums.length-1);
    }
}
