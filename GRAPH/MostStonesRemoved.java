package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.



Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
 */
public class MostStonesRemoved {
    static class Disjoint_Set{
        List<Integer> parent=new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        Disjoint_Set(int n ){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }

        int findUltimateParent(int node){
            if(node != parent.get(node)){
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
    public int removeStones(int[][] stones) {
        int totalStones = stones.length;
        int maxRow =0,maxCol=0;
        //to get total # of rows and col
        for(int i=0;i<totalStones;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);
        }
        //to connect stones at x , y we make disjoint set of size maxRow+maxCol+1
        Disjoint_Set ds = new Disjoint_Set(maxCol+maxRow+1);
        //we use hashmap to store which nodes have been visited
        HashMap<Integer,Integer> stonesNode = new HashMap<>();
        for(int i=0;i<totalStones;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1]+maxRow+1;
            ds.doUnion(nodeRow,nodeCol);
            stonesNode.put(nodeRow,1);
            stonesNode.put(nodeCol,1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> it : stonesNode.entrySet()){
            if(it.getKey()==ds.findUltimateParent(it.getKey()))count++;
        }
        return totalStones-count;
    }
}
