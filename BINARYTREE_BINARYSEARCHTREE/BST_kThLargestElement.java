package com.company.binaryTree;
/*
https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.
 */
public class BST_kThLargestElement {
    int i = 0; // Variable to keep track of the current index

    // Recursive helper method to find the Kth largest element in the BST
    private int solve(Node root, int[] k) {
        if (root == null) return -1; // Base case: reached the end of a branch

        int right = solve(root.right, k); // Recursively call solve on the right subtree
        if (right != -1) return right; // If Kth largest is found in the right subtree, return it

        i++; // Increment the index as a new node is visited

        if (i == k[0]) {
            return root.data; // If current index matches K, return the data of the current node
        }

        return solve(root.left, k); // Recursively call solve on the left subtree
    }

    // Method to find the Kth largest element in the BST
    public int kthLargest(Node root, int K) {
        int[] k = new int[]{K}; // Create an array to hold K
        return solve(root, k); // Call the solve method with the root node and k array
    }
}
