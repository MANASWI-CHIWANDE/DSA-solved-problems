package com.company.SearchingAndSorting;

public class BinarySearch_Recursion {
    static int recursion(int[] arr,int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid =(start+end)/2;
        if(arr[mid]==target) return mid;
        if(arr[mid]>target){
            return recursion(arr,target,start,mid-1);
        }
        else{
            return recursion(arr,target,mid+1,end);
        }
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,67,8};
        int target = 3;
        System.out.println(recursion(arr,3,0, arr.length));
    }
}
