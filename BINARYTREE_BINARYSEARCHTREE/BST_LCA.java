package com.company.binaryTree;
/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class BST_LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            // Both p and q are smaller than the root, so LCA must be in the left subtree
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            // Both p and q are greater than the root, so LCA must be in the right subtree
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // One node is on the left and the other is on the right, or one node is equal to the root
            return root;
        }
    }
}
