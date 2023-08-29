

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/is-graph-bipartite/
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
Return true if and only if it is bipartite.
A bipartite graph is a graph which can be coloured using 2 colours such that no adjacent nodes have the same colour. Any linear graph with no cycle is always a bipartite graph. With a cycle, any graph with an even cycle length can also be a bipartite graph. So, any graph with an odd cycle length can never be a bipartite graph.
 */
public class GraphBipartite_dfs {
    class Pair {
        int node;
        int color;

        Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    private boolean bfs(int[][] graph, int cur, int color, int[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(cur, color));
        vis[cur] = color;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.node;
            int clr = pair.color;

            for (int neighbour : graph[node]) {
                if (vis[neighbour] == -1) {
                    q.offer(new Pair(neighbour, (clr + 1) % 2));
                    vis[neighbour] = (clr + 1) % 2;
                } else if (vis[neighbour] == clr) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][]graph,int cur,int color,int[] vis){
        vis[cur]=color;
        for(int neighbours : graph[cur]){
            if(vis[neighbours]==-1){
                if(!dfs(graph, neighbours, (color+1)%2, vis))return false;
            }
            else if(vis[neighbours]!=-1 && vis[cur]==vis[neighbours])return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v= graph.length;
        int[] vis = new int[v];
        Arrays.fill(vis,-1);
        for(int i=0;i<v;i++){
            if(vis[i]==-1){
                if(!dfs(graph,0,0,vis))return false;
            }
        }
        return true;
    }
}
