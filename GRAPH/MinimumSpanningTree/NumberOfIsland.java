
import java.util.ArrayList;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-islands
You are given a n,m which means the row and column of the 2D matrix and an array of  size k denoting the number of operations. Matrix elements is 0 if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator has two integer A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island are there in the matrix after each operation.You need to return an array of size k.
Note : An island means group of 1s such that they share a common side.



Example 1:

Input: n = 4
m = 5
k = 4
A = {{1,1},{0,1},{3,3},{3,4}}

Output: 1 1 2 2
Explanation:
0.  00000
    00000
    00000
    00000
1.  00000
    01000
    00000
    00000
2.  01000
    01000
    00000
    00000
3.  01000
    01000
    00000
    00010
4.  01000
    01000
    00000
    00011
 */
public class NumberOfIsland {
    static class DisjointSet{
        List<Integer> parent =new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        DisjointSet(int n){
            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        int findUltimateParent(int node){
            if(node!=parent.get(node)){
                int ulp = findUltimateParent(parent.get(node));
                parent.set(node,ulp);
            }
            return parent.get(node);
        }
        void doUnion(int u,int v){
            int ulp_u=findUltimateParent(u);
            int ulp_v=findUltimateParent(v);
            if(ulp_u==ulp_v)return;
            if(size.get(ulp_u)>= size.get(ulp_v)){
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_v)+size.get(ulp_u));
            }
            else{
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
            }
        }
    }
    private boolean isValid(int rows,int cols,int row,int col){
        if(row>=0 && row<rows && col>=0 && col<cols)return true;
        else return false;
    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        List<Integer> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(rows*cols+1);
        boolean[][] vis = new boolean[rows][cols];
        int count=0;
        for(int i=0;i< operators.length;i++){
            int row = operators[i][0];
            int col = operators[i][1];
            if(vis[row][col]){
                ans.add(count);
                continue;
            }
            vis[row][col]=true;
            count++;
            int[]dr = {1,-1,0,0};
            int[]dc = {0,0,1,-1};
            for(int index=0;index<4;index++){
                int adjR = row+dr[index];
                int adjC = col+dc[index];
                if(isValid(rows,cols,adjR,adjC)){
                    if(vis[adjR][adjC]){
                        int node = row*cols+col;
                        int adjNode = adjR*cols+adjC;
                        if(ds.findUltimateParent(node)!=ds.findUltimateParent(adjNode)){
                            count--;
                            ds.doUnion(node,adjNode);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
