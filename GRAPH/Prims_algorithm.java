package com.company.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

 */
public class Prims_algorithm {
    public static class Pair implements Comparable<Pair>{
        int a ;int b;
        Pair(int node,int weight){
            this.a=node;
            this.b=weight;
        }
        @Override
        public int compareTo(Pair p2){
            return this.b-p2.b;//ascending order
        }
    }
    static int spanningTree(int V, int E, int edges[][]){
        // Code Here.
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            int node = edges[i][0];
            int neigh=edges[i][1];
            int wt = edges[i][2];
            adj.get(node).add(new Pair(neigh,wt));
            adj.get(neigh).add(new Pair(node, wt));
        }
        int mstCost=0;
        boolean visited[]=new boolean[V];//mst set
        PriorityQueue<Pair> pq =new PriorityQueue<>();//non mst set
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            if(!visited[cur.a]){
                visited[cur.a]=true;
                mstCost+=cur.b;
                for(Pair p: adj.get(cur.a)){
                    if(!visited[p.a]){
                        pq.add(new Pair(p.a,p.b));
                    }
                }
            }
        }
        return mstCost;
    }

}
