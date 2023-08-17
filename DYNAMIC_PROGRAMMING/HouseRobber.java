package com.company.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
https://www.codingninjas.com/studio/problems/house-robber-ii_839733?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
A thief needs to rob money in a street. The houses in the street are arranged in a circular manner. Therefore the first and the last house are adjacent to each other. The security system in the street is such that if adjacent houses are robbed, the police will get notified.

Given an array of integers “Arr” which represents money at each house, we need to return the maximum amount of money that the thief can rob without alerting the police.
 */
public class HouseRobber {
    private static long solve(List<Integer> valueInHouse){
        long prev = valueInHouse.get(0);
        long prev2 = 0;
        long curr ;
        for(int i =1;i< valueInHouse.size();i++){
            long pick =  valueInHouse.get(i);
            if(i>1)pick+=prev2;
            long unpick = prev;
            curr=Math.max(pick,unpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static long houseRobber(int[] valueInHouse) {
        // Write your code here.
        if(valueInHouse.length==1)return valueInHouse[0];
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 =new ArrayList<>();
        for(int i=0;i< valueInHouse.length;i++){
            if(i!=0) arr1.add(valueInHouse[i] );
            if(i!= valueInHouse.length-1) arr2.add(valueInHouse[i] );
        }
        long ans1 = solve(arr1);
        long ans2 = solve(arr2);

        return Math.max(ans2,ans1);
    }
}
