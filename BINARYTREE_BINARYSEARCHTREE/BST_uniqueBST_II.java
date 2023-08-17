package com.company.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
https://leetcode.com/problems/unique-binary-search-trees-ii/
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 */
public class BST_uniqueBST_II {
    class Pair{
        int start ;
        int end;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public HashMap<Pair,List<TreeNode>> dp;
    public List<TreeNode> generateTrees(int n) {
        dp= new HashMap<>();
        return func_memo(1,n,dp);
    }
    private List<TreeNode> func_memo(int start,int end ,HashMap<Pair,List<TreeNode>> dp){
        List<TreeNode> variations=new ArrayList<>();
        if(end<start){
            variations.add(null);
            return variations;
        }
        if(dp.containsKey(new Pair(start,end)))return dp.get(new Pair(start,end));
        for(int i=start;i<=end;i++){
            List<TreeNode> left = func_memo(start,i-1,dp);
            List<TreeNode> right = func_memo(i+1,end,dp);
            for(TreeNode l:left){
                for (TreeNode r: right){
                    TreeNode root = new TreeNode(i,l,r);
                    variations.add(root);
                }
            }
        }
        dp.put(new Pair(start,end),variations);
        return variations;
    }
}
