package com.company.binaryTree;
import  java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class PreOrder_traversal {

    private void preOrder(TreeNode node,List<Integer> res){
        if(node==null)return;
        res.add(node.val);
        preOrder(node.left,res);
        preOrder(node.right,res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }
}
public class Traversal_PreOrder {

}
