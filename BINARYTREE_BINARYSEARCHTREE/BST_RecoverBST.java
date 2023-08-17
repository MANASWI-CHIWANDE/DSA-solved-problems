package com.company.binaryTree;
/*
https://leetcode.com/problems/recover-binary-search-tree/description/
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 */
public class BST_RecoverBST {
    private TreeNode first;   // Smaller misplaced node
    private TreeNode last;    // Larger misplaced node
    private TreeNode middle;  // Second larger misplaced node (only applicable when two adjacent nodes are swapped)
    private TreeNode prev;    // Previous node while traversing

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null) {
            if (prev.val > root.val) {  // Check if nodes are misplaced
                if (first == null) {
                    first = prev;   // Assign the first misplaced node
                    middle = root;  // Assign the second misplaced node
                } else {
                    last = root;    // Assign the last misplaced node
                }
            }
        }
        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = null;
        last = null;
        middle = null;
        prev = null;

        inorder(root);  // Traverse the tree to find misplaced nodes

        if (first != null && last != null) {
            swapValues(first, last);  // Swap values of the first and last misplaced nodes
        } else if (first != null && middle != null) {
            swapValues(first, middle);  // Swap values of the first and second misplaced nodes
        }
    }

    private void swapValues(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
