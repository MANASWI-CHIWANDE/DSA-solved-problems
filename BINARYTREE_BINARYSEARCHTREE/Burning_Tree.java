package com.company.binaryTree;

import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/burning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=burning-tree
Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire.
 It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
Input:
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value
8 is set on fire.
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.
 */
public class Burning_Tree {
    private static void markParent(Node root, HashMap<Node,Node> parentChild){
        Queue<Node> q =new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.left!=null){
                parentChild.put(node.left,node);
            }
            if(node.right!=null){
                parentChild.put(node.right,node);
            }
        }
    }
    private static void findTarget(Node root,Node[] target,int tar){
        if(root==null)return;
        if(root.data==tar) target[0]=root;
        findTarget(root.left,target,tar);
        findTarget(root.right,target,tar);
    }
    public static int minTime(Node root, int tar)
    {
        int time  =0;
        if(root==null)return 0;
        HashMap<Node,Node> parentChild = new HashMap<>();//stores parent of child Hashmap <Child,Parent>
        markParent(root,parentChild);
        Node[] targ = new Node[1];
        findTarget(root,targ,tar);
        Node target = targ[0];
        Queue<Node> q =new LinkedList<>();
        q.offer(target);
        HashMap<Node,Boolean> visited = new HashMap<>();
        visited.put(target,true);
        while (!q.isEmpty()){
            int size = q.size();

            for(int i =0;i<size;i++){
                Node curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parentChild.get(curr)!=null && visited.get(parentChild.get(curr))==null){
                    q.offer(parentChild.get(curr));
                    visited.put(parentChild.get(curr),true);
                }
                time++;
            }
        }

        return time;
    }
}
