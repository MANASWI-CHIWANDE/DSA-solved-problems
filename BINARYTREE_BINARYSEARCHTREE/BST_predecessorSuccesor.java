package com.company.binaryTree;

public class BST_predecessorSuccesor {
    // Find predecessor (node with greatest value smaller than the given node) in a BST
    public TreeNode predecessor(TreeNode root, TreeNode node) {
        TreeNode pred = null; // Variable to store the predecessor node

        while (root != null) {
            if (root.val >= node.val) {
                // If current node value is greater than or equal to the target node value, move to the left subtree
                root = root.left;
            } else {
                // If current node value is smaller than the target node value, update pred and move to the right subtree
                pred = root;
                root = root.right;
            }
        }

        return pred;
    }

    // Find successor (node with smallest value greater than the given node) in a BST
    public TreeNode successor(TreeNode root, TreeNode node) {
        TreeNode succ = null; // Variable to store the successor node

        while (root != null) {
            if (root.val <= node.val) {
                // If current node value is smaller than or equal to the target node value, move to the right subtree
                root = root.right;
            } else {
                // If current node value is greater than the target node value, update succ and move to the left subtree
                succ = root;
                root = root.left;
            }
        }

        return succ;
    }
}
