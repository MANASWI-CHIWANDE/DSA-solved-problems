package com.company.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given an array nodes. It contains 7 integers, which represents the value of nodes of the binary tree in level order traversal. You are also given a root of the tree which has a value equal to nodes[0].
Your task to construct a binary tree by creating nodes for the remaining 6 nodes.
Example:
Input:
nodes = [1 2 3 4 5 6 7]
Output:
         1
       /   \
     2       3
   /  \     /  \
   4  5    6   7
 */
public class binaryTree {
    private static class Node{
        int val;
        Node left;
        Node right;
        private Node(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }
    public static void createTree(Node root0, ArrayList<Integer> v ){
        //we make queqe and add the root element in it
        Queue<Node> Q = new LinkedList<>();
        Q.add(root0);
        int i=1;
        int n = v.size();
        while(Q.size()!=0 && i<n){
            Node temp = Q.remove();
            temp.left=new Node(v.get(i++));
            Q.add(temp.left);
            temp.right=new Node(v.get(i++));
            Q.add(temp.right);
        }
    }
}
