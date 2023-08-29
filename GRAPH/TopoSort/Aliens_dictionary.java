

import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/alien-dictionary/1
Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.


Example 1:

Input:
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
We will analyze every consecutive pair to find out the order of the characters.
The pair “baa” and “abcd” suggests ‘b’ appears before ‘a’ in the alien dictionary.
The pair “abcd” and “abca” suggests ‘d’ appears before ‘a’ in the alien dictionary.
The pair “abca” and “cab” suggests ‘a’ appears before ‘c’ in the alien dictionary.
The pair “cab” and “cad” suggests ‘b’ appears before ‘d’ in the alien dictionary.
So, [‘b’, ‘d’, ‘a’, ‘c’] is a valid ordering.

 */
public class Aliens_dictionary {
    // Method to perform topological sorting
    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        List<Integer> topo = new ArrayList<>();

        // For getting indegree
        for (int i = 0; i < V; i++) {
            for (int ele : adj.get(i)) {
                indegree[ele]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Adding initial nodes having indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int e : adj.get(node)) {
                indegree[e]--;
                if (indegree[e] == 0)
                    q.add(e);
            }
        }
        return topo;
    }

    // Method to find the order of characters in the dictionary
    public String findOrder(String[] dict, int n, int k) {
        // Vertices in the graph == k
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Constructing the graph
        for (int i = 1; i < n; i++) {
            String s1 = dict[i - 1];
            String s2 = dict[i];
            int length = Math.min(s1.length(), s2.length());
            for (int j = 0; j < length; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    // Adding an edge from s1.charAt(j) to s2.charAt(j)
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Performing topological sorting
        List<Integer> topo = topoSort(k, adj);

        // Building the resulting order string
        StringBuilder ans = new StringBuilder();
        for (int ele : topo) {
            ans.append((char) (ele + 'a'));
        }

        return ans.toString();
    }
}
