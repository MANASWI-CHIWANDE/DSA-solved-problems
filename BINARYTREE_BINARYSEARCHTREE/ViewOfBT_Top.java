package com.company.binaryTree;
import java.util.*;
/*
Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position then consider the extreme ones only(i.e. leftmost and rightmost).
nput:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
 */

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class Tuple{
    Node node;
//    int level;
    int vertical;

    Tuple(Node node, int vertical) {
        this.node = node;
//        this.level = level;
        this.vertical = vertical;
    }
}
public class ViewOfBT_Top {

    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer,Integer>map=new TreeMap<>();
        q.offer(new Tuple(root,0));
        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int vertical = it.vertical;

            if(!map.containsKey(vertical)){
                map.put(vertical,it.node.data);
            }

            // Step 4: Enqueue the left and right child nodes for the next level
            if (it.node.left != null) {
                q.offer(new Tuple(it.node.left,  it.vertical - 1));
            }

            if (it.node.right != null) {
                q.offer(new Tuple(it.node.right,  it.vertical + 1));
            }
        }
        for(int tmap:map.values()){
            ans.add(tmap);
        }

        return ans;

    }

    public ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer,Integer>map=new TreeMap<>();
        q.offer(new Tuple(root,0));
        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int vertical = it.vertical;

            map.put(vertical,it.node.data);

            // Step 4: Enqueue the left and right child nodes for the next level
            if (it.node.left != null) {
                q.offer(new Tuple(it.node.left,  it.vertical - 1));
            }

            if (it.node.right != null) {
                q.offer(new Tuple(it.node.right,  it.vertical + 1));
            }
        }
        for(int tmap:map.values()){
            ans.add(tmap);
        }

        return ans;
    }
}
