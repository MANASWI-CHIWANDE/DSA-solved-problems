package com.company.binaryTree;
/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
 */
public class Populate_nextRight {
    class Node1 {
        public int val;
        public Node1 left;
        public Node1 right;
        public Node1 next;

        public Node1() {}

        public Node1(int _val) {
            val = _val;
        }

        public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node1 connect(Node1 root) {
        if (root == null)
            return root; // If the root is null, return null

        Node1 level = root; // Start with the current level set to the root

        while (level != null) {
            Node1 curr = level; // Start with the current node set to the current level

            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right; // Set the next pointer of the left child to the right child
                }

                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left; // Set the next pointer of the right child to the left child of the next node
                }

                curr = curr.next; // Move to the next node on the same level
            }

            level = level.left; // Move to the leftmost node of the next level
        }

        return root; // Return the modified root node
    }

}
