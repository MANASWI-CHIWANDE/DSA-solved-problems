package com.company.binaryTree;
import java.util.*;
public class Construct_BT_from_Inorder_Preorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder,0, preorder.length, inorder,0, inorder.length, map);
    }

    private TreeNode buildTree(int[] preorder, int preStart,int preEnd,
                               int[] inorder, int InStart ,int InEnd,
                               HashMap<Integer, Integer> map){
        if(preStart>preEnd || InStart>InEnd)return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int InRoot = map.get(node.val);
        int numsLeft = InRoot-InStart;
        node.left = buildTree(preorder,preStart+1,preStart+numsLeft,inorder,InStart,InRoot-1,map);
        node.right= buildTree(preorder,preStart+numsLeft+1,preEnd,inorder,InRoot+1,InEnd,map);
        return node;
    }
}
