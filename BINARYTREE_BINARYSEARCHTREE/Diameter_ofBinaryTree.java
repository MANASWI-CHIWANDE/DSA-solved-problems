package com.company.binaryTree;

public class Diameter_ofBinaryTree {
    private int diameterOfBinaryTree(TreeNode root,int maxi) {
        if(root==null)return 0;
        int lh = diameterOfBinaryTree(root.left,maxi);
        int rh = diameterOfBinaryTree(root.right,maxi);
        maxi = Math.max(maxi,lh+rh);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameterOfBinaryTree(root,diameter[0]);
        return diameter[0];
    }
}
