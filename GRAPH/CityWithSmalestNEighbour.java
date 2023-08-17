package com.company.graph;

import java.util.Arrays;

/*
https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
 */
public class CityWithSmalestNEighbour {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance =new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            distance[i][i]=0;
        }
        for(int i=0;i<edges.length;i++){
            distance[edges[i][0]][edges[i][1]]=edges[i][2];
            distance[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        //Floyd Warshall algorithm
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    distance[i][j]=Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                }
            }
        }
        int cntCity=n;
        int cityNo = -1;
        for(int  city=0;city<n;city++){
            int cnt=0;
            for(int adjCity=0;adjCity<n;adjCity++){
                if(distance[city][adjCity]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=cntCity){
                cntCity=cnt;
                cityNo=city;
            }
        }
        return cityNo;
    }
}
