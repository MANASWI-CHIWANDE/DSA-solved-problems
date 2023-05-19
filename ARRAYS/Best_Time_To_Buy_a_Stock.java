package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Best_Time_To_Buy_a_Stock {
    /*public static int maximun_profit(int nums[]){
        int max= 0, n= nums.length, diff=0;
        for(int i =0;i<n-1;i++){
            for(int j=i+1;j<=n-1;j++){
                if(nums[i]<nums[j]){
                diff = nums[j]-nums[i];
                if(max==0){ if(diff >0) max = diff; }
                if (max < diff) max = diff;
            }
            }
        }
        return max;
    }*/
    public static int maximun_profit(int nums[]){
        int max= 0, n= nums.length,minValue = Integer.MAX_VALUE;
        for(int i =0;i<=n-1;i++){
            minValue=Math.min(nums[i],minValue);
            max = Math.max(max,nums[i]-minValue);
        }
        return max;
    }
    public static void main(String[] args) {
        int [] prices ={1,2};
        int maxProfit = maximun_profit(prices);
        System.out.println(maxProfit);
    }
}
