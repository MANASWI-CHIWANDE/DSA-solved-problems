
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1
Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
 */
public class NumberOfDistinctIsland_GFG {
    private void dfs(int i,int j,boolean[][] vis,List<String> vec,int row,int col,int[][] grid){
        vis[i][j]=true;
        vec.add(toString(i-row,j-col));
        int[] drow={-1,0,1,0};
        int[] dcol={0,-1,0,1};
        for(int k=0;k<4;k++){
            int irow = i+drow[k];
            int jcol = j+dcol[k];
            if(irow>=0 && irow< grid.length && jcol>=0 && jcol<grid[0].length && !vis[irow][jcol] && grid[irow][jcol]==1){
                dfs(irow, jcol, vis, vec, row, col, grid);
            }
        }
    }
    private String toString(int a ,int b){
        return "("+Integer.toString(a)+","+Integer.toString(b)+")";
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        HashSet<List<String>> set = new HashSet<>();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    List<String> vec= new ArrayList<>();
                    dfs(i,j,vis,vec,i,j,grid);
                    set.add(vec);
                }
            }
        }
        return set.size();
    }
}
