package com.company.recursion_subsequence;
import java.util.*;
/*
Given a list arr of N integers, print sums of all subsets in it.
https://practice.geeksforgeeks.org/problems/subset-sums2234/1
 */
public class Subset_Sum {
    class Solution{
        private void reucrsion(ArrayList<Integer> arr, int N,int i,int sum,ArrayList<Integer> ans){
            if(i==N){
                ans.add(sum);
                sum=0;
                return;
            }
            int currNum=arr.get(i);
            reucrsion(arr,N,i+1,sum+currNum,ans);
            reucrsion(arr,N,i+1,sum,ans);
        }
        ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
            ArrayList<Integer> ans = new ArrayList<>();
            int sum=0;
            reucrsion(arr,N,0,sum,ans);
            return ans;
        }
    }
}
