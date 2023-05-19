package com.company.arrays;
import java.util.*;
//problem : https://www.codingninjas.com/codestudio/problems/920321?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website


public class Longest_Subarray_with_givenSum {
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        int n = arr.size();
        int count=0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                int sum = arr.get(i)+arr.get(j);
                for(int k =i ;k<j;k++){
                    sum =sum +arr.get(k);
                    if(sum==0) count =Math.max(j-i+1,count) ;
                }
            }
        }
        return count;
    }
}
