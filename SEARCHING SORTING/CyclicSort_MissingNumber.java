package com.company.SearchingAndSorting;
/*
https://leetcode.com/problems/missing-number/
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class CyclicSort_MissingNumber {
    private void swap(int[]arr,int first,int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    public int missingNumber(int[] arr) {
        int i =0;
        while(i<arr.length){
            int correct = arr[i];
            if(arr[i]<arr.length&&arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else i++;
        }
        //search for first missing nu,ber
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j)return j;

        }
        return arr.length;
    }
}
class Sol {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length;
        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
            expectedSum += i;
            actualSum += nums[i];
        }
        return expectedSum - actualSum;
    }
}
