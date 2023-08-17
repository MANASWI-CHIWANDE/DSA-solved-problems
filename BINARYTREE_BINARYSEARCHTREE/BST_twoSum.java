package com.company.binaryTree;

import java.util.Stack;

/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
 */
public class BST_twoSum {

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator r = new BSTIterator(root,true);
        BSTIterator l = new BSTIterator(root,false);
        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j==k)return true;
            else if (i+j<k) i=l.next();
            else j = r.next();
        }
        return false;
    }
}
public class BSTIterator{
    private Stack<TreeNode> s = new Stack<>();

    boolean reversed = true;
    //reverse true === before
    //reverse false === next
    BSTIterator(TreeNode root , boolean isReverse){
        reversed = isReverse;
        pushAll(root);
    }
    public int next(){
        TreeNode cur = s.pop();
        if(reversed ==false )pushAll(cur.right);
        else pushAll(cur.left);
        return cur.val;
    }
    private void pushAll(TreeNode node){
        while(node!=null){
            s.push(node);
            if(reversed == true){
                node =node.right;
            }
            else{
                node = node.left;
            }
        }
    }
}}
