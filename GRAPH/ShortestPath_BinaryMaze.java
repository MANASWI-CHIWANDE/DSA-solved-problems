package com.company.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/shortest-path-in-binary-matrix/
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
 */
public class ShortestPath_BinaryMaze {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; // Starting or ending cell is blocked
        }

        int[][] directions = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1} };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1; // Mark the starting cell as visited

        int pathLength = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                if (row == n - 1 && col == n - 1) {
                    return pathLength; // Reached the bottom-right cell
                }

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                        queue.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 1; // Mark the neighbor cell as visited
                    }
                }
            }

            pathLength++; // Increment path length for each level of BFS
        }

        return -1; // No clear path found
    }
}
