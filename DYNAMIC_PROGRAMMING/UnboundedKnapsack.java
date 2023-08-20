
/*
https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
Given a set of N items, each with a weight and a value, represented by the array w[] and val[] respectively. Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int N = 2, W = 3;
        int val[] = {1, 1};
        int wt[] = {2, 1};
        System.out.println(knapSack(N,W,val,wt));
    }

    static int tabulation(int N, int W, int val[], int wt[]){
        int[][]dp= new int[N][W+1];
        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = ((int) i/wt[0]) * val[0];
        }
        for(int i=1;i<N;i++){
            for(int j =0;j<=W;j++){
                int notTaken = dp[i-1][j];
                int take=0;
                if(wt[i]<=W){
                    take= val[i]+dp[i][j-wt[i]];
                }
                dp[i][j]=  Math.max(notTaken,take);
            }
        }
        return dp[N-1][W];
    }

    static int knapSack(int N, int W, int val[], int wt[]) {
        // code here
        return recursion(W,val,wt,N-1);
    }
    private static int recursion(int w , int val[],int wt[],int index){
        if(index==0){
            return (int)(w/wt[index])*val[index];
        }
        int notTaken = recursion(w,val,wt,index-1);
        int take=0;
        if(wt[index]<=w){
            take= val[index]+recursion(w-wt[index],val,wt,index);
        }
        return Math.max(notTaken,take);
    }
}
