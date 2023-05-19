package com.company.recursion_subsequence;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Subsequence_withSUMequalK {
    public static void recursion(int i,int[] nums,int n, int sum,int target,List<Integer> arr){
        if(i==  n){
            if(sum==target){
                for(int ele:arr){
                    System.out.print(ele+" ");
                }
                System.out.println();
                return;
            }
        }
        arr.add(nums[i]);
        sum=sum+nums[i];
        recursion(i+1,nums,n,sum,target,arr);
        arr.remove(arr.size()-1);
        sum=sum-nums[i];
        recursion(i+1,nums,n,sum,target,arr);
    }

    public static void main(String[] args) {
        int []num = {1,2,1};
        int target=2;

        recursion(0,num,num.length,0,target,new ArrayList<>());
    }

}
