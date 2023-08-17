package com.company.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://www.codingninjas.com/studio/problems/kruskal%E2%80%99s-minimum-spanning-tree-algorithm_1082553?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

 */
public class Kruskals_algorithm {
    static class DisJoint_Set{
        List<Integer> rank=new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        public DisJoint_Set(int n){
            for(int i=0;i<=n;i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }
        int findParent(int node){
            if(node==parent.get(node)){
                return node;
            }
            int ulp = findParent(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
        public void unionByRank(int u,int v){
            int ulp_u=findParent(u);
            int ulp_v=findParent(v);
            if(ulp_u==ulp_v)return;
            if(rank.get(ulp_u)< rank.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
            }
            else if(rank.get(ulp_v)< rank.get(ulp_u)){
                parent.set(ulp_v,ulp_u);
            }
            else{
                parent.set(ulp_v,ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u,rankU+1);
            }
        }
        public void unionBySize(int u,int v){
            int ulp_u=findParent(u);
            int ulp_v=findParent(v);
            if(ulp_u==ulp_v)return;
            if(size.get(ulp_u)< size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_u)+ size.get(ulp_v));
            }
            else if(size.get(ulp_v)< size.get(ulp_u)){
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+ size.get(ulp_v));
            }
        }
    }
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int _src, int _dest, int _wt) {
            this.src = _src; this.dest = _dest; this.weight = _wt;
        }
        // Comparator function used for
        // sorting edges based on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        // Write your code here.
        List<Edge> edges = new ArrayList<>();
        for(ArrayList<Integer> list : graph){
            edges.add(new Edge(list.get(0),list.get(1),list.get(2)));
        }
        DisJoint_Set ds = new DisJoint_Set(n);
        Collections.sort(edges);
        int mstWeight=0;
        for(int i=0;i<edges.size();i++){
            int wt= edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            if(ds.findParent(u)!=ds.findParent(v)){
                mstWeight+=wt;
                ds.unionBySize(u,v);
            }
        }
         return mstWeight;
    }
}
