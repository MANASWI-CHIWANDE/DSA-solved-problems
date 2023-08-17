package com.company.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_BFS_KahnsAlgorithm {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] topSort=new int[V];
        int[] indegree= new int[V];

        //for getting indegree
        for(int i=0;i<V;i++){
            for(int ele: adj.get(i)){
                indegree[ele]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        //adding initial nodes having indegree 0
        for(int i =0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int index=0;
        while(!q.isEmpty()){
            int node = q.poll();
            topSort[index]=node ;
            index++;
            for(int e : adj.get(node)){
                indegree[e]--;
                if(indegree[e]==0)q.add(e);
            }
        }
        return topSort;
    }
}
