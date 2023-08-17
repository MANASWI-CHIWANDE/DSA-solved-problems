package com.company.binaryTree;

public class BST_DeleteNode {
    private TreeNode findlr(TreeNode node){
        if(node.right==null){
            return node;
        }
        return findlr(node.right);
    }
    private TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }
        else if (root.right==null){
            return root.left;
        }
        else{
            TreeNode rightChild = root.right;
            TreeNode lastRight= findlr(root.left);
            lastRight.right=rightChild;
            return root.left;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        if(root.val==key){
            return helper(root);
        }
        TreeNode dum = root;
        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val==key){
                    root.left=helper(root.left);
                    break;
                }
                else{
                    root=root.left;
                }
            }
            else{
                if(root.right!=null && root.right.val==key){
                    root.right=helper(root.right);
                    break;
                }
                else{
                    root=root.right;
                }
            }
        }
        return dum;
    }
}
