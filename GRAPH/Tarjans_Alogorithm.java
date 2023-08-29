
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/critical-connections-in-a-network/description/
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.
 */
public class Tarjans_Alogorithm {

    private void tarjansALGO(List<List<Integer>> adj, List<List<Integer>> result, boolean[] vis,
                             int curr, int par, int time, int[] dt, int[] low) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int neighbour : adj.get(curr)) {
            if (neighbour == par)
                continue;
            else if (!vis[neighbour]) {
                tarjansALGO(adj, result, vis, neighbour, curr, time, dt, low); // Fix: Swap curr and neighbour
                low[curr] = Math.min(low[curr], low[neighbour]);
                if (low[neighbour] > dt[curr]) {
                    result.add(Arrays.asList(curr, neighbour)); // Fix: Simplify list creation
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int node1 = connection.get(0);
            int node2 = connection.get(1);
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        boolean[] vis = new boolean[n];
        int[] dt = new int[n];
        int[] low = new int[n];
        int time = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                tarjansALGO(adj, result, vis, i, -1, time, dt, low);
            }
        }
        return result;
    }
}
