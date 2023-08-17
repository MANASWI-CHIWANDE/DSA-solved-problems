package com.company.binaryTree;

import java.util.*;

public class Traversal_InOrder {
    private static void inorderTraversal(TreeNode node,List<Integer> res){
        if(node==null){
            return;
        }
        inorderTraversal(node.left,res);
        res.add(node.val);
        inorderTraversal(node.right,res);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root,res);
        return res;
    }
}
