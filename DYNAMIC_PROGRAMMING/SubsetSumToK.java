
import java.util.Arrays;
import java.util.List;

/*
https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

 */
public class SubsetSumToK {
    private static boolean tabulation(int n, int target, int arr[]){
        boolean[][]dp = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(arr[0]<=target) dp[0][arr[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean notpick = dp[i-1][j];
                boolean pick=false;
                if(arr[i]<=j){
                    pick = dp[i-1][j-arr[i]];
                }
                dp[i][j]= notpick || pick;
            }
        }
        return dp[n-1][target];
    }
    private static boolean recursion(int i, int target , int[]arr,int[][]dp){
        if(target==0)return true;
        if(i==0)return arr[i] == target;
        if(dp[i][target]!=-1)return dp[i][target] != 0;
        boolean notPick = recursion(i-1,target,arr,dp);

        boolean pick = true;
        if(arr[i]<=target){
            target=target-arr[i];
            pick = recursion(i-1,target,arr,dp);
        }
        dp[i][target]=notPick || pick?1:0;
        return pick || notPick;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][]dp=new int[n][k+1];
        for(int[] ar1 : dp){
            Arrays.fill(ar1,-1);
        }
        return recursion(n-1,k,arr,dp);
    }
    public static void main(String args[]) {

        int arr[] = {1,2,3,4};
        int k=4;
        int n = arr.length;

        if(tabulation(n,k,arr))
            System.out.println("Subset with given target found");
        else
            System.out.println("Subset with given target not found");
    }
}
