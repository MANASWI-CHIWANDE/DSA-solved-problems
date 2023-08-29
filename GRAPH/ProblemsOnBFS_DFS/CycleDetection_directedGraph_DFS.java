
import java.util.ArrayList;

/*
https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
 */
public class CycleDetection_directedGraph_DFS {
    private boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] recursionStack,int cur ){
        vis[cur]=true;
        recursionStack[cur]=true;
        for(int i=0;i<adj.get(cur).size();i++){
            int e = adj.get(cur).get(i);
            if(recursionStack[e]){
                return true;
            }
            else if(!vis[e]){
               if (dfs(adj, vis, recursionStack, e))return true;
            }
        }
        recursionStack[cur]=false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis= new boolean[V];
        boolean[] recursionStack = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(adj,vis,recursionStack,i))return true;
            }
        }
        return false;

    }
}
