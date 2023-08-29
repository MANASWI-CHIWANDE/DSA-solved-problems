

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=strongly-connected-components-kosarajus-algo
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 */
public class KosarajuAgorithm_SCC {
    private void topoSort(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] vis, int node){
        vis[node]=true;
        for(int ele: adj.get(node)){
            if(!vis[ele]){
                topoSort(adj,stack,vis,ele);
            }
        }
        stack.push(node);
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node){
        vis[node]=true;
        for(int ele: adj.get(node)){
            if(!vis[ele]){
                dfs(adj,vis,ele);
            }
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        //step 1: do toposort to get nodes in stack as per toposort
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topoSort(adj,stack,vis,i);
            }
        }
        //step 2: transpose the graph
        ArrayList<ArrayList<Integer>> adjTranspose = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjTranspose.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            vis[i]=false;
            for(int neighbour : adj.get(i)){
                adjTranspose.get(neighbour).add(i);
            }
        }
        //do dfs on transposed graph
        int scc=0;
        while (!stack.isEmpty()){
            int node = stack.pop();
            if(!vis[node]){
                scc++;
                dfs(adjTranspose,vis,node);
            }
        }
        return scc;
    }
}
