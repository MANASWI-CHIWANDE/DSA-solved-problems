
import java.util.Arrays;

/*
https://leetcode.com/problems/unique-paths-ii/
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.



Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 */
public class UniquePath_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev  =new int[n];
        for(int i =0;i<m;i++){
            int[] temp = new int[n];
            for(int j =0;j<n;j++){
                if(obstacleGrid[0][0]==1)return 0;
                if(i==0 && j==0){
                    temp[j]=1;continue;
                }

                int a =0;int b=0;
                if(i>0 && obstacleGrid[i][j]!=1) a = prev[j];
                if(j>0 && obstacleGrid[i][j]!=1) b = temp[j-1];
                temp[j]=a+b;
            }
            prev=temp;
        }
        return prev[n-1];
    }
}
