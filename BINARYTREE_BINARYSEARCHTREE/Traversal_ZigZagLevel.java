package com.company.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
 */
public class Traversal_ZigZagLevel {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;
        boolean flag = true;// to keep track of level in binary tree
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();//to get number of node present in queue at that moment
            List<Integer> answer = new ArrayList<>();
            for(int i=0;i<n;i++){
                root=q.poll();

                if(root.left!=null){
                    q.offer(root.left);
                }
                if(root.right!=null){
                    q.offer(root.right);
                }
                if(flag) answer.add(root.val);
                else answer.add(0,root.val);
            }result.add(answer);
            flag=!flag;
        }
        return result;
    }
}
