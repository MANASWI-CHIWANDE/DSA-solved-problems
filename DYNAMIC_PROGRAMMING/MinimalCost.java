
import java.util.Arrays;

/*
https://www.codingninjas.com/studio/problems/minimal-cost_8180930?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
This is a follow-up question to “Frog Jump” discussed in the previous article. In the previous question, the frog was allowed to jump either one or two steps at a time. In this question, the frog is allowed to jump up to ‘K’ steps at a time. If K=4, the frog can jump 1,2,3, or 4 steps at every index.
 */
public class MinimalCost {
    //memoisation
    static int solveUtil(int ind, int[] height, int[] dp, int k){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int mmSteps = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){
            if(ind-j>=0){
                int jump = solveUtil(ind-j, height, dp, k)+ Math.abs(height[ind]- height[ind-j]);
                mmSteps= Math.min(jump, mmSteps);
            }
        }
        return dp[ind]= mmSteps;

    }

    static int solve(int n, int[] height , int k){
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        //return solveUtil(n-1, height, dp, k);
        return solveTab(n,height,k,dp);
    }

    //tabulation
    static int solveTab(int n, int[] height , int k,int[]dp){
        dp[0]=0;
        for(int i=1;i<n;i++){
            int mmsteps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump = dp[i-j]+Math.abs(height[i]-height[i-j]);
                    mmsteps=Math.min(jump,mmsteps);
                }
            }
            dp[i]=mmsteps;
        }
        return dp[n-1];
    }
    public static void main(String args[]) {

        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int k=2;
        System.out.println(solve(n,height,k));
    }
}


