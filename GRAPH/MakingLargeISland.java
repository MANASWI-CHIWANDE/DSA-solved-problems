package com.company.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
https://leetcode.com/problems/making-a-large-island/
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.



Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 */
public class MakingLargeISland {
    static class DisjointSet{
        List<Integer> parent =new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        DisjointSet(int n){
            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        int findUltimateParent(int node){
            if(node!=parent.get(node)){
                int ulp = findUltimateParent(parent.get(node));
                parent.set(node,ulp);
            }
            return parent.get(node);
        }
        void doUnion(int u,int v){
            int ulp_u=findUltimateParent(u);
            int ulp_v=findUltimateParent(v);
            if(ulp_u==ulp_v)return;
            if(size.get(ulp_u)>= size.get(ulp_v)){
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_v)+size.get(ulp_u));
            }
            else{
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
            }
        }
    }
    private boolean isValid(int m,int n,int row,int col){
        if(row>=0 && row<m && col>=0 && col<n)return true;
        else return false;
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[]dr = {0,0,1,-1};
        int[]dc= {1,-1,0,0};
        DisjointSet ds = new DisjointSet(m*n+1);
        //making connected components
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)continue;
                if(grid[i][j]==1){
                    for(int index =0;index<4;index++){
                        int adjR = i+dr[index];
                        int adjC = j+dc[index];
                        if(isValid(m,n,adjR,adjC) && grid[adjR][adjC]==1){
                            int node = i*n +j;
                            int adjNode = adjR*n+adjC;
                            ds.doUnion(node,adjNode);
                        }
                    }
                }
            }
        }

        int maxSize=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)continue;
                for(int index =0;index<4;index++){
                    int adjR = i+dr[index];
                    int adjC = j+dc[index];
                    if(isValid(m,n,adjR,adjC) && grid[adjR][adjC]==1){
                        int adjNode = adjR*n+adjC;
                        set.add(ds.findUltimateParent(adjNode));
                    }
                }
                int size=0;
                for (Integer e : set) {
                    size+=ds.size.get(e);
                }
                maxSize=Math.max(maxSize,size+1);
            }
        }
        for(int node =0;node<m*n;node++){
            maxSize=Math.max(maxSize,ds.size.get(node));
        }
        return maxSize;
    }
}
