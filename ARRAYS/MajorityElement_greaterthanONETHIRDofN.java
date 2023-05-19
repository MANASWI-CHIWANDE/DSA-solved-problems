package com.company.arrays;
import java.util.*;
//question : https://leetcode.com/problems/majority-element-ii/
public class MajorityElement_greaterthanONETHIRDofN {
    /*//BRUTE FORCE APPROACH
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        int n = nums.length;
        for(int i = 0;i< nums.length;i++){
            int cnt=0;
            for(int j =0;j<nums.length;j++){
                if(nums[i]==nums[j])cnt++;
            }
            if(cnt>n/3){
                if(!lst.contains(nums[i]))  lst.add(nums[i]);
            }
        }
        return lst;
    }*/
    /*//BETTER APPROACH USING HASHMAP
    public List<Integer> majorityElement(int[] nums){
        List<Integer> lst = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            int value = map.getOrDefault(ele,0);
            map.put(ele,value+1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()>n/3) lst.add(e.getKey());
        }
        return lst;
    }*/
    //OPTIMAL APPROACH
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        int n = nums.length;
        int num1 = -1, num2 = -1,count1=0,count2=0;
        for(int ele : nums){
            if(ele == num1)count1++;
            else if(ele == num2) count2++;
            else if(count1==0) {num1 = ele; count1=1;}
            else if(count2==0) {
                num2 = ele; count2=1;
            }
            else {count1--;count2--;}
        }
        int c1=0,c2=0;
        for(int ele : nums){
            if(ele == num1)c1++;
            if(ele==num2)c2++;
        }
        if(c1>n/3){
            if(!lst.contains(num1))  lst.add(num1);

        }
        if(c2>n/3){
            if(!lst.contains(num2))  lst.add(num2);
        }
        return lst;
    }
}
