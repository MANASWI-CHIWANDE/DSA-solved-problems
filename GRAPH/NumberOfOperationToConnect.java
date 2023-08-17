package com.company.graph;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/number-of-operations-to-make-network-connected/
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 */
public class NumberOfOperationToConnect {
    class DisjointSet{
        List<Integer> parent=new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        int extraConnection;
        DisjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
            extraConnection=0;
        }
        int find_UltimateParent(int node){
            if(node!= parent.get(node)){
                int ulp = find_UltimateParent(parent.get(node));
                parent.set(node,ulp);
            }
            return parent.get(node);
        }
        public void doUnion(int u,int v){
            int ulp_u=find_UltimateParent(u);
            int ulp_v=find_UltimateParent(v);
            if(ulp_u==ulp_v){
                extraConnection++;
                return;
            }
            if(size.get(ulp_v)< size.get(ulp_u)){
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_v)+size.get(ulp_u));
            }
            else if(size.get(ulp_v)> size.get(ulp_u)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
            }
            else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
        public int getExtraConnection(){
            return extraConnection;
        }
        public int getNumberofConnectedCompnent(){
            int nc=0;
            for(int i=0;i<parent.size();i++){
                if(i==parent.get(i))nc++;
            }
            return nc;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<connections.length;i++){
            ds.doUnion(connections[i][0],connections[i][1]);
        }
        int extraEdges= ds.getExtraConnection();
        int nc = ds.getNumberofConnectedCompnent();
        return extraEdges>=nc-1?nc-1:-1;
    }
}
