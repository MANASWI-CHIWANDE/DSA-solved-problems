package com.company.binaryTree;
import java.util.*;
public class Traversal_Boundary {
    class Node {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }
    private boolean isLeaf(Node node){
        if(node.right==null && node.left==null)return true;
        else return false;
    }
    private void getLeftBoundaryNodes(Node node,ArrayList <Integer> boundary){
        Node cur = node.left;
        while(cur!=null){
            if(!isLeaf(cur))boundary.add(cur.data);
            if(cur.left!=null)cur=cur.left;
            else cur = cur.right;
        }
    }
    private void getLeafNodes(Node node ,ArrayList <Integer> boundary ){
        if(isLeaf(node)){
            boundary.add(node.data);
            return;
        }
        if(node.left!=null)getLeafNodes(node.left,boundary);
        if(node.right!=null)getLeafNodes(node.right,boundary);
    }
    private void getRightBoundaryNode(Node node,ArrayList <Integer> boundary){
        Node curr= node.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr))tmp.add(curr.data);
            if(curr.right!=null)curr=curr.right;
            else curr=curr.left;
        }
        for(int i=tmp.size()-1;i>=0;--i){
            boundary.add(tmp.get(i));
        }
    }
    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> result = new ArrayList<>();
        getLeftBoundaryNodes(node,result);
        getLeafNodes(node,result);
        getRightBoundaryNode(node,result);
        return result;
    }
}
