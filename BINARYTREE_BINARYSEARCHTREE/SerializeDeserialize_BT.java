package com.company.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or
 transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class SerializeDeserialize_BT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder s =new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                s.append("null,");
                continue;
            }
            s.append(node.val+",");
            q.offer(node.left);
            q.offer(node.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())return null;
        String[] values = data.split("null");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q =new LinkedList<>();
        for (int i =1;i< values.length;i++){
            TreeNode parent = q.poll();
            if(values[i]!="null"){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                q.offer(left);
            }
            if(!values[++i].equals("null")){
                TreeNode right= new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.offer(right);
            }
        }
        
        return root;
    }
}
