package com.company.binaryTree;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        if(p.val==q.val){
            isSameTree(p.left,q.left);
            isSameTree(p.right,q.right);
            return true;
        }
        else{
            return false;
        }
    }
}
