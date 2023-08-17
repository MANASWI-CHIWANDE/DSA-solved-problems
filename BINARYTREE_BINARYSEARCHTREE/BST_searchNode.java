package com.company.binaryTree;
/*
https://leetcode.com/problems/search-in-a-binary-search-tree/
You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */
public class BST_searchNode {
    private TreeNode foo(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root; // If the current node is null or matches the target value, return the current node
        } else if (root.val < val) {
            return foo(root.right, val); // If the current node's value is less than the target value, recursively search in the right subtree
        } else {
            return foo(root.left, val); // If the current node's value is greater than the target value, recursively search in the left subtree
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return foo(root, val); // Perform the search for the target value and return the result node
    }
}
