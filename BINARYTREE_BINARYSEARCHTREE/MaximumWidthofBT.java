package com.company.binaryTree;

import java.util.*;
/*
https://leetcode.com/problems/maximum-width-of-binary-tree/
Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
 */
public class MaximumWidthofBT {
    class Pair{
        TreeNode node ;
        int index;
        Pair(TreeNode node,int index){
            this.index=index;
            this.node=node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int ans=0;
        Queue<Pair> q =new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int n=q.size();//size of queue
            int minValue = q.peek().index;
            int first=0,last=0;
            for(int i=0;i<n;i++){
                int currId=q.peek().index-minValue;
                root=q.peek().node;
                q.poll();
                if(i==0)first=currId;
                if(i==n-1)last=currId;
                if(root.left!=null)q.offer(new Pair(root.left,currId*2+1));
                if(root.right!=null)q.offer(new Pair(root.right,currId*2+2));
            }
            ans=Math.max(ans,last-first+1);

        }
        return ans;
    }
}
