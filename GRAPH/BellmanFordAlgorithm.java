package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;

/*
iven a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: If the Graph contains a negative cycle then return an array consisting of only -1.
E = [[0,1,9]]
S = 0
Output:
0 9
Explanation:
Shortest distance of all nodes from
source is printed.
 */
public class BellmanFordAlgorithm {
    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, 100000000);
        distance[S] = 0;

        ArrayList<Edge> allEdges = new ArrayList<>();
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            allEdges.add(new Edge(u, v, wt));
        }

        // Perform V-1 iterations
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : allEdges) {
                int u = edge.source;
                int v = edge.destination;
                int wt = edge.weight;
                if (distance[u] != 100000000 && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : allEdges) {
            int u = edge.source;
            int v = edge.destination;
            int wt = edge.weight;
            if (distance[u] != 100000000 && distance[u] + wt < distance[v]) {
                // Graph contains a negative cycle
                return new int[]{-1};
            }
        }

        return distance;
    }
}
