package com.company.binaryTree;
/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class BST_kThSmallestElement {
    public int kthSmallest(TreeNode root, int k) {
        int ans=0;
        TreeNode cur = root;
        while(cur!=null){
            if(k==0){
                break;
            }
            if(cur.left==null){
                ans=cur.val;
                k--;
                cur=cur.right;
            }
            else{
                TreeNode prev = cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    ans=cur.val;
                    k--;
                    cur=cur.right;
                }
            }
        }
        return ans;
    }
}
