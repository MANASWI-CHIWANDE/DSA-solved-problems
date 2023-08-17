package com.company.binaryTree;
import java.util.*;
public class Traversal_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return result;
        q.offer(root);
        while (!q.isEmpty()){
            int level = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i =0;i<level;i++){
                TreeNode node = q.poll();
                if(node.left!= null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                ans.add(node.val);
            }
            result.add(ans);
        }
        return result;
    }
}
