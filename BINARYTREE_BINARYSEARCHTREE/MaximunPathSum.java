package com.company.binaryTree;
/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path
Given the root of a binary tree, return the maximum path sum of any non-empty path.
Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
public class MaximunPathSum {
    private int maxPathSum(TreeNode node,int []maxi){
        if(node==null)return 0;
        int leftSum=maxPathSum(node.left,maxi);
        int rightSum=maxPathSum(node.right,maxi);
        if(leftSum<0)leftSum=0;
        if(rightSum<0)rightSum=0;
        maxi[0] = Math.max(maxi[0],node.val+leftSum+rightSum);
        return node.val+Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        int[]answer=new int[1];
        answer[0]=Integer.MIN_VALUE;
        maxPathSum(root,answer);
        return answer[0];

    }
}
