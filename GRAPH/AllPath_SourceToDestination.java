package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/all-paths-from-source-to-target/description/
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class AllPath_SourceToDestination {
    private void dfs(int[][] graph , int cur , int target, boolean[] vis , List<Integer> path,List<List<Integer>> result){
        if(cur==target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i =0;i<graph[cur].length;i++){
            int e = graph[cur][i];
            if(!vis[e]){
                vis[e]=true;
                path.add(e);
                dfs(graph, e, target, vis, path, result);
                vis[e]=false;
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int v =graph.length;
        boolean[] vis=new boolean[v];
        int source = 0,destination = v-1;
        dfs(graph,0,v-1,vis,new ArrayList<>(Arrays.asList(source)),result);
        return result;
    }
}
