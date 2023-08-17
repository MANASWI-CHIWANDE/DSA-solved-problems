package com.company.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Traversal_MorrisPreorder {
    public List<Integer> PreorderTraversal(TreeNode root){
        List<Integer > arr=new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                arr.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode prev=cur.left;
                while(prev.right!=null&&prev.right!=cur){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    arr.add(cur.val);
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
        return arr;
    }
}
