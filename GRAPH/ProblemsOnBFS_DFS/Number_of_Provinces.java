
import java.util.ArrayList;

/*
https://leetcode.com/problems/number-of-provinces/
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
 */
public class Number_of_Provinces {
    private void dfs(ArrayList<ArrayList<Integer>> adj ,int start,boolean[] vis){
        vis[start]=true;
        for(int i =0;i<adj.get(start).size();i++){
            int e = adj.get(start).get(i);
            if(!vis[e]){
                dfs(adj,e,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        //getting vertices in graph
        int vertices = isConnected.length;
        // creating list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<vertices;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                if(isConnected[i][j] == 1 && i!=j ){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count =0;
        boolean[] vis=new boolean[vertices];
        for(int i =0;i<vertices;i++){
            if(!vis[i]){
                count++;
                dfs(adj,i,vis);
            }
        }
        return count;
    }
}
