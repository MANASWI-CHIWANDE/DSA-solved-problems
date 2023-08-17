package com.company.graph;
/*
https://leetcode.com/problems/surrounded-regions/description/
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class Surrounded_Region {
    private void dfs(int i ,int j,char[][]board,boolean[][]vis){
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || vis[i][j] || board[i][j]=='X'){
            return;
        }
        vis[i][j]=true;
        dfs(i, j-1, board, vis);
        dfs(i, j+1, board, vis);
        dfs(i+1, j, board, vis);
        dfs(i-1, j, board, vis);
    }
    public void solve(char[][] board) {
        int row = board.length;
        int column = board[0].length;

        boolean[][] vis = new boolean[row][column];

        for(int i=0;i<row;i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(i,0,board,vis);
            }
            if(!vis[i][column-1] && board[i][column-1]=='O'){
                dfs(i,column-1,board,vis);
            }
        }

        for(int j=0;j<column;j++){
            if(!vis[0][j] && board[0][j]=='O'){
                dfs(0,j,board,vis);
            }
            if(!vis[row-1][j] && board[row-1][j]=='O'){
                dfs(row-1,j,board,vis);
            }
        }

        for(int i =1;i<row-1;i++){
            for(int j=1;j<column-1;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}
