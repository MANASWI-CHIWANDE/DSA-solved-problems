
import java.util.ArrayList;
import java.util.Stack;

/*
https://practice.geeksforgeeks.org/problems/topological-sort/1
Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
 */
public class TopologicalSort_DFS {
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int cur, Stack<Integer> stack){
        vis[cur]=true;
        for(int neighbours : adj.get(cur)){
            if(!vis[neighbours]){
                dfs(adj, vis, neighbours, stack);
            }
        }
        stack.push(cur);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int v = adj.size();
        int[] ans = new int[v];
        boolean[] vis = new boolean[v];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(adj,vis,i,stack);
            }
        }
        for(int i=0;i<v;i++){
            ans[i]=stack.pop();
        }
        return ans;
    }
}
