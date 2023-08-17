package com.company.binaryTree;

class Solution1 {
    private void countNodes(TreeNode root,int[] ans){
        if(root==null)return ;
        ans[0]++;
        countNodes(root.left,ans);
        countNodes(root.right,ans);
    }
    public int countNodes(TreeNode root) {
        int[] ans = new int[1];
        countNodes(root,ans);
        return ans[0];
    }
}
public class CountTotalNodes {
    private int findLeftHeight(TreeNode root){
        if(root==null)return 0;
        int cnt=0;
        while(root!=null){
            root=root.left;
            cnt++;
        }
        return cnt;
    }
    private int findRightHeight(TreeNode root){
        if(root==null)return 0;
        int cnt=0;
        while(root!=null){
            root=root.right;
            cnt++;
        }
        return cnt;
    }
    public int countNodes(TreeNode root){
        if(root==null)return 0;
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);
        if(lh==rh)return (2<<(lh)-1);
        else return countNodes(root.left)+countNodes(root.right)+1;
    }
}
