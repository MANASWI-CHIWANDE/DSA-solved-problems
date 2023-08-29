
import java.util.*;

/*
https://leetcode.com/problems/find-eventual-safe-states/
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 */

public class EventualSafeState {
    public List<Integer> eventualSafeNodes_BFS(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int v = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[v];
        for (int node = 0; node < v; node++) {
            for (int neighbour : graph[node]) {
                adj.get(neighbour).add(node);
                indegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
    public List<Integer> eventualSafeNodes_dfs(int[][] graph) {
        int V = graph.length;

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] isSafe = new boolean[V];

        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(graph, i, visited, pathVisited, isSafe);
            }
        }

        for(int i=0;i<V;i++){
            if(isSafe[i]) safeNodes.add(i);
        }

        return safeNodes;
    }

    public boolean dfs(int[][] adj, int node, boolean[] visited,
                       boolean[] pathVisited,boolean[] isSafe){
        visited[node] = true;
        pathVisited[node] = true;

        for(int it : adj[node]){
            if(!visited[it]){
                if(dfs(adj,it,visited,pathVisited,isSafe)){
                    return true;
                }
            }else if(pathVisited[it]){
                return true;
            }
        }
        isSafe[node] = true;
        pathVisited[node] = false;
        return false;
    }
}
