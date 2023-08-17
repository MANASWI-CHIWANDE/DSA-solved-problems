package com.company.SearchingAndSorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={5,3,4,2,1};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] nums,int low,int high){
        if(low>=high)return;
        int start = low;
        int end = high;
        int mid = start+(end-start)/2;
        int pivot= nums[mid];

        while(start<=end){

            //alsoa reason why it will not sort if array is already sorted unlike in merge sort
            while(nums[start]<pivot){
                start++;
            }
            while(nums[end]>pivot){
                end--;
            }
            if(start<=end){
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;end--;
            }
        }
        //now pivot is at correct index
        quickSort(nums,low,end);
        quickSort(nums,start,high);
    }
}
