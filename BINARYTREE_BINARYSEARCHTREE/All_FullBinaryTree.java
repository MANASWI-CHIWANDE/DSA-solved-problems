package com.company.binaryTree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/all-possible-full-binary-trees/
Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 */
public class All_FullBinaryTree {
    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> memo = new HashMap<>();
        return generateTrees(n, memo);
    }

    private List<TreeNode> generateTrees(int n, Map<Integer, List<TreeNode>> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> result = new ArrayList<>();

        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftTrees = generateTrees(i, memo);
            List<TreeNode> rightTrees = generateTrees(n - i - 1, memo);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        memo.put(n, result);
        return result;
    }
}

