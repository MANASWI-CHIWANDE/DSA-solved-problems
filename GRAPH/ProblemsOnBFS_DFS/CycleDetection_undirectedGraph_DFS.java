

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph
public class CycleDetection_undirectedGraph_DFS {
    private boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int cur,int parent){
        vis[cur]=true;
        for(int i =0;i<adj.get(cur).size();i++){
            int e = adj.get(cur).get(i);
            if(vis[e] && e!=parent){
                return true;
            }
            else if(!vis[e]){
                if(dfs(adj, vis,e, cur))return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i =0;i<V;i++){
            if(!vis[i]){
                if(dfs(adj,vis,0,-1))return true;
            }
        }
        return false;
    }
}
