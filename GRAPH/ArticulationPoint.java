package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/articulation-point-1/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=articulation-point
Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph
 */
public class ArticulationPoint {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int cur, int par, int dt[], int low[], int time, boolean[] vis, boolean[] ap) {
        vis[cur] = true;
        dt[cur] = low[cur] = ++time;
        int children = 0;
        for (int neighbour : adj.get(cur)) {
            if (neighbour == par)
                continue;
            else if (vis[neighbour]) {
                low[cur] = Math.min(low[cur], dt[neighbour]);
            } else {
                dfs(adj, neighbour, cur, dt, low, time, vis, ap);
                low[cur] = Math.min(low[cur], low[neighbour]);
                if (dt[cur] <= low[neighbour] && par != -1) {
                    ap[cur] = true;
                }
                children++;
            }
        }
        if (par == -1 && children > 1)
            ap[cur] = true;
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        boolean[] ap = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, i, -1, dt, low, time, vis, ap);
            }
        }
        for (int i = 0; i < V; i++) {
            if (ap[i])
                result.add(i);
        }
        if (result.size() == 0)
            return new ArrayList<>(Arrays.asList(-1));
        return result;
    }
}
