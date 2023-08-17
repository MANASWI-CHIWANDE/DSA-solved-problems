package com.company.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection_undirectedGraph_BFS {
    class Pair{
        int node;
        int parent ;
        Pair(int a , int b){
            this.node=a;
            this.parent=b;
        }
    }
    private boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int src){
        vis[src]=true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,-1));
        while (!q.isEmpty()){
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();
            for(int i =0;i<adj.get(node).size();i++){
                int e = adj.get(node).get(i);
                if(!vis[e]){
                    vis[e]=true;
                    q.offer(new Pair(e,node));
                }
                else if(parent!=e){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        for(int i =0;i<V;i++){
            if(!vis[i]){
                if(bfs(adj,vis,i))return true;
            }
        }
        return false;
    }
}
