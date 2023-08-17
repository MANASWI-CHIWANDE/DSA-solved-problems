package com.company.binaryTree;

import java.util.*;

/*
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.
 */
public class All_NodesDistance_K_inBT {
    private void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parentChild) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                parentChild.put(node.left, node);
                q.offer(node.left); // Add left child to the queue for further processing
            }
            if (node.right != null) {
                parentChild.put(node.right, node);
                q.offer(node.right); // Add right child to the queue for further processing
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        HashMap<TreeNode, TreeNode> parentChild = new HashMap<>();
        markParent(root, parentChild);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);

        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k)
                break;
            distance++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && visited.get(curr.left) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                TreeNode parent = parentChild.get(curr);
                if (parent != null && visited.get(parent) == null) {
                    q.offer(parent);
                    visited.put(parent, true);
                }
            }
        }

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            result.add(node.val);
        }

        return result;
    }
}
