

import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).
 */
public class KnapSack_01 {
    public static void main(String[] args) {
        int n =3;
        int w = 3;
        int[] values={1,2,3};
        int[] wight={4,5,1};
        System.out.println(knapSack(w,wight,values,n));
    }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        int[][]dp =new int[n][W+1];
        for(int[]arr:dp){
            Arrays.fill(arr,-1);
        }
        //return recursion(W, wt, val, n-1);
        return memoisation(W, wt, val, n-1,dp);
    }
    static int tabulation(int W, int wt[], int val[], int n){
        int[][]dp =new int[n][W+1];
        for (int i=wt[0];i<=W;i++){
            dp[0][i]=val[0];
        }
        for(int index = 1;index<n;index++){
            for(int capacity = 0;capacity<=W;capacity++){
                int notTaken = dp[index-1][capacity];
                int taken = Integer.MIN_VALUE;
                if(wt[index]<=capacity){
                    taken= val[index]+dp[index-1][capacity-wt[index]];
                }
                dp[index][capacity]=Math.max(taken,notTaken);
            }
        }
        return dp[n-1][W];
    }
    static int recursion(int W, int wt[], int val[], int index){
        if(index==0){
            if(wt[0]<=W)return val[0];
            else return 0;
        }
        int notPick = recursion(W,wt,val,index-1);
        int pick = Integer.MIN_VALUE;
        if(wt[index]<=W){
            pick = val[index]+recursion(W-wt[index], wt, val, index-1);
        }
        return Math.max(notPick,pick);
    }
    static int memoisation(int W, int wt[], int val[], int index,int[][]dp){
        if(index==0){
            if(wt[0]<=W)return val[0];
            else return 0;
        }
        if(dp[index][W]!=-1)return dp[index][W];
        int notPick = memoisation(W,wt,val,index-1,dp);
        int pick = Integer.MIN_VALUE;
        if(wt[index]<=W){
            pick = val[index]+memoisation(W-wt[index], wt, val, index-1,dp);
        }
        return dp[index][W]=Math.max(notPick,pick);
    }
}
