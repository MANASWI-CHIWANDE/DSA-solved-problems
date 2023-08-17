package com.company.SearchingAndSorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    ////time complexity = nlogn
    public int findKthLargest_Sort(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //time complexity = n+k *logn
    public int findKthLargest_HeapSort(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    //time complexity = n (average), worst = n^2
    public int findKthLargest_QuickSelect(int[] nums, int k){
        k = nums.length-k;
        quickSort(nums,0, nums.length-1,k);
        return nums[k];
    }
    private void quickSort(int[] nums,int low,int high,int k ){
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
        if(end<k){
            quickSort(nums,start,high,k);
        }
        else quickSort(nums,low,end, k);

    }
}
