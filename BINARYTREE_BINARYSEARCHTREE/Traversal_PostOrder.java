package com.company.binaryTree;
import java.util.*;
class Recursive_sol {
    private void postorderTraversal(TreeNode node, List<Integer> res){
        if(node == null)return;
        postorderTraversal(node.left,res);
        postorderTraversal(node.right,res);
        res.add(node.val);

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root,res);
        return res;
    }
}
class Iterative_2Stacks{
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if(root.left!=null){
                s1.push(root.left);
            }
            if(root.right!=null){
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()){
            res.add(s2.pop().val);
        }
        return res;
    }
}
