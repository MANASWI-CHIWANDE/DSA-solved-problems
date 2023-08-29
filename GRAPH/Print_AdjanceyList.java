
/*
https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-adjacency-list
Given the adjacency list representation of an undirected graph
your task is to complete the function printGraph() that takes the number of vertices (V) and the adjacency list as input parameters.
The function should return a new adjacency list, where each adjacency list contains the vertex itself at first position then all its adjacent nodes, in the same order of the given adjacency list of that vertex.


 */
import java.util.*;
public class Print_AdjanceyList {
    public ArrayList<ArrayList<Integer>> printGraph(
            int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        for(int i =0;i<V;i++){
            adj.get(i).add(0,i);
        }
        return adj;
    }
}
