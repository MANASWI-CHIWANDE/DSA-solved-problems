
import java.util.Arrays;

/*
We are given an ‘N*M’ matrix. Every cell of the matrix has some chocolates on it, mat[i][j] gives us the number of chocolates. We have two friends ‘Alice’ and ‘Bob’. initially, Alice is standing on the cell(0,0) and Bob is standing on the cell(0, M-1). Both of them can move only to the cells below them in these three directions: to the bottom cell (↓), to the bottom-right cell(↘), or to the bottom-left cell(↙).

When Alica and Bob visit a cell, they take all the chocolates from that cell with them. It can happen that they visit the same cell, in that case, the chocolates need to be considered only once.

They cannot go out of the boundary of the given matrix, we need to return the maximum number of chocolates that Bob and Alice can together collect.
 https://www.codingninjas.com/studio/problems/chocolate-pickup_3125885?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

 */
public class Ninja_andHisFriends {
    private static int recursion(int r, int c , int[][]grid , int i,int j1,int j2,int dp[][][]){
        if(j1<0 || j2<0 || j1>=c || j2>=c)return (int)-1e9;
        if(i==r-1){
            if(j1==j2)return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int maxi =Integer.MIN_VALUE;
        for(int di=-1;di<=1;di++){
            for(int dj=-1;dj<=1;dj++){
                int ans =0;
                if(j1==j2){
                    ans = grid[i][j1]+recursion(r, c, grid, i, j1+di, j2+dj,dp);
                }
                else ans = grid[i][j1]+grid[i][j2]+recursion(r, c, grid, i, j1+di, j2+dj,dp);
                maxi=Math.max(ans,maxi);
            }
        }
        return dp[i][j1][j2]=maxi;
    }
    static int maximumChocolates_tab(int n, int m, int[][] grid) {

        int dp[][][] = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        //Outer Nested Loops for travering DP Array
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = Integer.MIN_VALUE;

                    //Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            if ((j1 + di < 0 || j1 + di >= m) ||
                                    (j2 + dj < 0 || j2 + dj >= m))

                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            maxi = Math.max(ans, maxi);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m - 1];
    }
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        int dp[][][] = new int[r][c][c];

        for (int row1[][]: dp) {
            for (int row2[]: row1) {
                Arrays.fill(row2, -1);
            }
        }
        return recursion(r,c,grid,0,0,c-1,dp);
    }
}
