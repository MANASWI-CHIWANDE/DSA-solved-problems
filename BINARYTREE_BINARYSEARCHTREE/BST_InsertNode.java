package com.company.binaryTree;
/*
https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
Example 1:
Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
 */
public class BST_InsertNode {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // If the root is null, create a new TreeNode with the given value and return it
        if (root == null)
            return new TreeNode(val);

        TreeNode curr = root; // Initialize a current pointer to traverse the tree

        while (true) {
            if (curr.val > val) {
                // If the current node's value is greater than the given value, move to the left subtree

                if (curr.left == null) {
                    // If the left child is null, create a new TreeNode with the given value
                    TreeNode newNode = new TreeNode(val);
                    curr.left = newNode; // Set the new node as the left child of the current node
                    break; // Exit the loop
                }

                curr = curr.left; // Move to the left child
            } else {
                // If the current node's value is less than or equal to the given value, move to the right subtree

                if (curr.right == null) {
                    // If the right child is null, create a new TreeNode with the given value
                    TreeNode newNode = new TreeNode(val);
                    curr.right = newNode; // Set the new node as the right child of the current node
                    break; // Exit the loop
                }

                curr = curr.right; // Move to the right child
            }
        }

        return root; // Return the modified root of the BST
    }

}
