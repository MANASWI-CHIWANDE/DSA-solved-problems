
import java.util.*;

/*
https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 */
public class NumberOfWays_toArriveDestination {
    static int mod = (int)(Math.pow(10, 9)+7);
    class Pair{
        int node, wt;
        public Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: roads){
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.wt- b.wt);
        pq.offer(new Pair(0, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;


        int[] count = new int[n];
        count[0] = 1;
        while(!pq.isEmpty()){
            Pair front = pq.poll();

            for(Pair e: adj.get(front.node)){

                if(e.wt+ front.wt < dist[e.node]){
                    dist[e.node] = e.wt+ front.wt;
                    pq.offer(new Pair(e.node, dist[e.node]));
                    count[e.node] = count[front.node];
                }
                else if(e.wt+ front.wt == dist[e.node]){
                    count[e.node] = (count[e.node]+ count[front.node]) %mod;
                }
            }
        }
        return count[n-1]%mod;

    }
}
