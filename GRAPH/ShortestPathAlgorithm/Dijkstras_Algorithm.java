
import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that  edge . You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S. You have to return a list of integers denoting shortest distance between each node and Source vertex S.
 */
class Solution {
    //with unit weight
    public int[] shortestPath(int[][] edges, int n,int m, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return distance;
    }
}
public class Dijkstras_Algorithm{
    static class Pair{
        int node;
        int dis;
        Pair(int node,int dis){
            this.node=node;
            this.dis=dis;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        boolean[] vis=new boolean[V];
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparing(pair -> pair.dis));
        pq.add(new Pair(S,0));
        distance[S]=0;
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int node = cur.node;
            if(vis[node])continue;
            vis[node]=true;
            int dis= cur.dis;
            for(ArrayList<Integer> ele:adj.get(node)){
                int neighbour_node = ele.get(0);
                int neighbour_dis = ele.get(1);
                if(!vis[neighbour_node]){
                    if(dis+neighbour_dis<distance[neighbour_node]){
                        distance[neighbour_node]=dis+neighbour_dis;
                    }
                    pq.add(new Pair(neighbour_node,distance[neighbour_node]));
                }
            }
        }
        return distance;
    }
}
