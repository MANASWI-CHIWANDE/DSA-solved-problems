package com.company.binaryTree;


import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
Example 1:
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
 */
public class MAximumLevel_sum {

    public int maxLevelSum(TreeNode root) {
        int maxi = Integer.MIN_VALUE;
        int level=0;
        int maxLevel=0;
        Queue<TreeNode> q =new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;
            for(int i=0;i<n;i++){
                root=q.poll();
                if(root.left!=null)q.offer(root.left);
                if(root.right!=null)q.offer(root.right);
                sum+= root.val;
            }
            level++;
            if(sum>maxi) {
                maxi = sum;
                maxLevel=level;
            }
        }
        return maxLevel;
    }
}
