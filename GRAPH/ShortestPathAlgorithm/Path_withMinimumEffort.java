

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 */
public class Path_withMinimumEffort {
    class Pair{
        int diff;
        int i_coordinate ;
        int j_coordinate;
        Pair(int diff,int i_coordinate,int j_coordinate){
            this.diff=diff;
            this.i_coordinate=i_coordinate;
            this.j_coordinate=j_coordinate;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;;
        int column = heights[0].length;
        int[][] difference = new int[row][column];
        for(int i=0;i<row;i++){
            Arrays.fill(difference[i],Integer.MAX_VALUE);
        }
        difference[0][0]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(pair -> pair.diff));
        pq.offer(new Pair(0,0,0));
        int[] drow={-1,1,0,0};
        int[]dcol={0,0,-1,1};
        while (!pq.isEmpty()){
            Pair cur = pq.poll();
            int i_=cur.i_coordinate;
            int j_= cur.j_coordinate;
            int diff = cur.diff;
            if(i_==row-1 && j_==column-1)return diff;
            for(int i=0;i<4;i++){
                int ni = i_+drow[i];
                int nj = j_+dcol[i];
                if(ni>=0 && nj>=0 && ni<row && nj <column){
                    int newDiff = Math.max(Math.abs(heights[i_][j_] - heights[ni][nj]), diff);
                    if (newDiff < difference[ni][nj]) {
                        difference[ni][nj] = newDiff;
                        pq.offer(new Pair(newDiff, ni, nj));
                    }
                }
            }
        }
        return 0;
    }
}
