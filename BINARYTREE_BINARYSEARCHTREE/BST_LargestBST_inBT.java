package com.company.binaryTree;
/*
https://practice.geeksforgeeks.org/problems/largest-bst/1
Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
 */
public class BST_LargestBST_inBT {
    class NodeValue{
        int count;
        int sum;
        int maxValue;
        int minValue;
        NodeValue(int a , int d,int b , int c){
            count = a;
            sum = d;
            maxValue = b;
            minValue = c;
        }
        NodeValue(){
            this.sum=0;
            this.count=0;
            this.maxValue=Integer.MIN_VALUE;
            this.minValue=Integer.MAX_VALUE;
        }
        NodeValue(int val){
            this.sum=val;
            this.count=1;
            this.minValue=val;
            this.maxValue=val;
        }
    }
    int max;
    private NodeValue helper(Node root){
        if(root==null){
            return new NodeValue();
        }
        if(root.left==null && root.right==null){
            max = Math.max(max, root.data);
            return new NodeValue(root.data);
        }
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        NodeValue res = new NodeValue();
        if(left.maxValue < root.data && right.minValue > root.data){
            //is a BST
            res.sum = root.data+ left.sum+ right.sum;
            max=Math.max(max, res.sum);
            res.count=left.count+right.count+1;
            res.maxValue=Math.max(root.data, right.maxValue);
            res.minValue=Math.min(root.data, left.minValue);

            //return new NodeValue(left.count+right.count+1,s,Math.max(root.data, right.maxValue),Math.min(root.data, left.minValue));
        }
        else{
            res.sum = Math.max(left.sum,right.sum);
            //max=Math.max(max, res.sum);
            res.count=Math.max(left.count, right.count);
            res.maxValue=Integer.MAX_VALUE;
            res.minValue=Integer.MIN_VALUE;
            //return new NodeValue(Math.max(left.count, right.count),Math.max(left.sum,right.sum),Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        return res;
    }
    // Return the size of the largest sub-tree which is also a BST

    void largestBst(Node root)
    {
        int max  = 0;
        // Write your code here
        int count =  helper(root).count;
        int sum = max;

    }
}
