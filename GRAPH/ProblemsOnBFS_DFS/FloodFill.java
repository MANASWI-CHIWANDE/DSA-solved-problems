

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/flood-fill/
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.



Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 */
class FloodFill_{
//    TIME COMPLEXITY = O(M*N);
//    SPACE COMPLEXITY = O(M*N);

    static class Pair{
        int row;
        int column;
        Pair(int r,int c){
            this.row=r;
            this.column=c;
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m =image.length;
        int n= image[0].length;
        if(image[sr][sc]==color)return image;
        int initialColor = image[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        image[sr][sc]=color;
        q.add(new Pair(sr,sc));
        vis[sr][sc]=true;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c= q.peek().column;
            q.poll();
            for(int i=0;i<4;i++){
                int row = r+drow[i];
                int col = c+dcol[i];

                if(image[row][col]==initialColor && row>=0 && row<m && col>=0 && col<n && vis[row][col]==false){
                    image[row][col]=color;
                    q.add(new Pair(row,col));
                }
            }
        }
        return image;
    }
}
public class FloodFill {
    private void dfs(int row, int column, int initialColor, int finalColor, int[][] image) {
        // Check if the current pixel is out of bounds or does not have the initial color
        if (row < 0 || row >= image.length || column < 0 || column >= image[0].length || image[row][column] != initialColor) {
            return;
        }

        // Fill the current pixel with the final color
        image[row][column] = finalColor;

        // Recursively visit all adjacent pixels in four directions
        dfs(row + 1, column, initialColor, finalColor, image); // Down
        dfs(row - 1, column, initialColor, finalColor, image); // Up
        dfs(row, column + 1, initialColor, finalColor, image); // Right
        dfs(row, column - 1, initialColor, finalColor, image); // Left
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0) {
            return image;
        }

        // If the starting pixel does not already have the final color,
        // perform the flood fill using the dfs function.
        if (image[sr][sc] != color) {
            dfs(sr, sc, image[sr][sc], color, image);
        }

        // Return the modified image.
        return image;
    }
}
