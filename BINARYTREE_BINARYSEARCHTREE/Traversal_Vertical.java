package com.company.binaryTree;

import java.util.*;

/*
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class Traversal_Vertical {
    class Pair {
        TreeNode node;
        int level;
        int vertical;

        Pair(TreeNode node, int level, int vertical) {
            this.node = node;
            this.level = level;
            this.vertical = vertical;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Step 1: Initialize the queue with the root node
        q.offer(new Pair(root, 0, 0));

        // Step 2: Traverse the tree level by level
        while (!q.isEmpty()) {
            Pair it = q.poll();
            int level = it.level;
            int vertical = it.vertical;

            // Step 3: Construct the map to store nodes based on their vertical and level
            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }

            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue<>());
            }

            map.get(vertical).get(level).offer(it.node.val);

            // Step 4: Enqueue the left and right child nodes for the next level
            if (it.node.left != null) {
                q.offer(new Pair(it.node.left, it.level + 1, it.vertical - 1));
            }

            if (it.node.right != null) {
                q.offer(new Pair(it.node.right, it.level + 1, it.vertical + 1));
            }
        }

        // Step 5: Retrieve the elements from the map and populate the result list
        for (TreeMap<Integer, PriorityQueue<Integer>> tmap : map.values()) {
            result.add(new ArrayList<>());

            for (PriorityQueue<Integer> queue : tmap.values()) {
                while (!queue.isEmpty()) {
                    result.get(result.size() - 1).add(queue.poll());
                }
            }
        }

        // Step 6: Return the final result
        return result;
    }

}
