package com.company.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal_Pre_In_Post_inONe {
    class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node,int num){
            this.node=node;
            this.num=num;
        }
    }
    public void Pre_In_Post(TreeNode root){
        if (root == null) return;
        List<Integer> prefix = new ArrayList<>();
        List<Integer> infix = new ArrayList<>();
        List<Integer> postfix = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();


        stack.push(new Pair(root,1));
        while(!stack.isEmpty()){
            Pair it = stack.pop();
            if(it.num==1){
                prefix.add(it.node.val);
                it.num++;
                stack.push(it);
                if(it.node.left!=null)stack.push(new Pair(it.node.left,1));
            }
            else if(it.num==2){
                infix.add(it.node.val);
                it.num++;
                stack.push(it);
                if(it.node.right!=null)stack.push(new Pair(it.node.right,1));
            }
            else{
                postfix.add(it.node.val);
            }
        }
    }
}
