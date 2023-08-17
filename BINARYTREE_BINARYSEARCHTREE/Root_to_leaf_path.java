package com.company.binaryTree;
import java.util.*;
/*
Given a Binary Tree of size N, you need to find all the possible paths from root node to all the leaf node's of the binary tree.
Example 1:
Input:
       1
    /     \
   2       3
Output: 1 2 #1 3 #
Explanation: All possible paths:  1->2  ,   1->3

 */
public class Root_to_leaf_path {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    private void Paths(Node node,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> arr){
        if(node==null){
            return;
        }
        arr.add(node.data);
        if(node.left==null && node.right==null){
            result.add(new ArrayList<>(arr));
        }
        Paths(node.left,result,arr);
        Paths(node.right,result,arr);
        arr.remove(arr.size()-1);
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        Paths(root,result,new ArrayList<>());
        return result;
    }
}
