package com.company.binaryTree;
import java.util.*;
class Solution{
    public int maxDepth(TreeNode root) {
        int length =0;
        if(root==null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level = q.size();
            TreeNode node = q.poll();
            for(int i=0;i<level;i++){
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            length++;
        }
        return length;
    }
}
public class MaximumDepthofBT {

}
