
import java.util.HashMap;

/*
https://leetcode.com/problems/knight-probability-in-chessboard/description/
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
 */
public class KnightInChessBoard {
    public double knightProbability(int n, int k, int row, int column) {
        HashMap<String , Double >map = new HashMap<String, Double>();
        return helper(n,k,row,column,map);
    }
    private double helper(int n, int k, int row, int column,HashMap<String , Double >map){
        int[][] direction={{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
        if(!isValid(n,row,column))return 0;
        if(k==0)return 1;
        String key = "("+row+","+column+","+k+")";
        if(map.containsKey(key))return map.get(key);
        double probability=0;
        for(int i=0;i<8;i++){
            probability += helper(n,k-1,row+direction[i][0],column+direction[i][1],map)/8.0;
        }
        map.put(key,probability);
        return probability;

    }
    private boolean isValid(int n,int ir,int ic){
        return ir >= 0 && ir < n && ic >= 0 && ic < n;
    }
}
