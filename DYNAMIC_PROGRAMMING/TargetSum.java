package com.company.dynamicProgramming;
/*
https://leetcode.com/problems/target-sum/
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
 */
public class TargetSum {
    static final int mod = (int)1e9+7;
    public static void main(String[] args) {
        int[] arr={1,1,1,1,1};
        int sum=3;
        System.out.println(tabulation(arr,sum));
    }
    public static int tabulation(int arr[],int sum){
        int totalSum=0;
        for(int ele:arr)totalSum+=ele;
        if(totalSum-sum<0)return 0;
        if((totalSum-sum)%2==1)return 0;
        int target = (totalSum-sum)/2;
        int n = arr.length;


        int[]prev =new int[target+1];
        if(arr[0]==0)prev[0]=2;
        else prev[0]=1;
        if(arr[0]!=0&& arr[0]<=target)prev[arr[0]]=1;
        for(int i=1;i<n;i++){
            int[]curr =new int[target+1];
            for(int j=0;j<=target;j++){
                int notPick = prev[j];
                int pick = 0;
                if(arr[i]<=j){
                    pick = prev[j-arr[i]];
                }
                curr[j]= (notPick+pick)%mod;
            }
            prev=curr;
        }

        return prev[target];

    }
    public static int findTargetSumWays(int arr[],int sum){
        int totalSum=0;
        for(int ele:arr)totalSum+=ele;
        if(totalSum-sum<0)return 0;
        if((totalSum-sum)%2==1)return 0;
        int target = (totalSum-sum)/2;
        return recursion(arr,target, arr.length-1);
    }
    private static int recursion(int[]arr,int target,int index){
        if(index==0){
            if(target==0 && arr[0]==0)return 2;
            if(target==0 || target==arr[0])return 1;
            else return 0;
        }
        int notPick = recursion(arr, target,index-1);
        int pick = 0;
        if(arr[index]<=target){
            pick = recursion(arr,target-arr[index],index-1);
        }
        return notPick+pick;
    }
}
