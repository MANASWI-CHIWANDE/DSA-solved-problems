
import java.util.ArrayList;
import java.util.Arrays;

/*
https://www.codingninjas.com/studio/problems/maximum-sum-of-non-adjacent-elements_843261?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
Problem Statement:

Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that no two elements of the subsequence are adjacent elements in the array.

Note: A subsequence of an array is a list with elements of the array where some elements are deleted ( or not deleted at all) and the elements should be in the same order in the subsequence as in the array.
 */
public class MaximumSumOfNonAdjacentElements {
    private static int spaceOptimization(ArrayList<Integer> nums){
        int prev = nums.get(0);
        int prev2=0;
        int curr;
        for(int i =1;i< nums.size();i++){
            int pick = nums.get(i)+ prev2;
            int notPick = prev;
            curr = Math.max(pick,notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    private static int tabulation(ArrayList<Integer> nums,int []dpp){
        dpp[0]= nums.get(0);
        for(int i =1;i< nums.size();i++){
            int pick = nums.get(i) ;
            if(i>1){
                pick+=dpp[i-2];
            }
            int unpick = dpp[i-1];
            dpp[i]=Math.max(pick,unpick);
        }
        return dpp[nums.size()-1];
    }
    private static int memeoisation(ArrayList<Integer> nums,int i,int[]dp){

        if(i==0)return nums.get(i);
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        int pick = nums.get(i) + memeoisation(nums,i-2,dp);
        int unpick = memeoisation(nums,i-1,dp);
        return dp[i]=Math.max(pick,unpick);
    }
    private static int recursion(ArrayList<Integer> nums,int i){
        if(i==0)return nums.get(i);
        if(i<0)return 0;
        int pick = nums.get(i) + recursion(nums,i-2);
        int unpick = recursion(nums,i-1);
        return Math.max(pick,unpick);
    }
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int[] dp = new int[nums.size()];
        Arrays.fill(dp,-1);
        //return recursion(nums, nums.size()-1);
        //return memeoisation(nums, nums.size()-1, dp);
        //return tabulation(nums,dp);
        return spaceOptimization(nums);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(4);
        nums.add(9);
        System.out.println(maximumNonAdjacentSum(nums));

    }
}
