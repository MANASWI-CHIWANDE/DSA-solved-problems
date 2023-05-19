package com.company.SearchingAndSorting;

import java.util.Arrays;

public class BinarySearch {
    public static boolean binarySearch(int[] arr,int key){
        int start = 0;
        boolean ans =false;
        int end = arr.length-1;int mid=0;
        mid = (start+end )/2;
        while(start<=end){

             if(arr[mid]==key ) ans = true;
             else{
                 if(arr[mid]>key){
                     end=mid-1;
                 }
                 else{
                     start=mid+1;
                 }
                 mid = (start+end )/2;
             }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10,12};
        int[] arr1 ={1,3,5,7,9};
        System.out.println(binarySearch(arr,8));
        System.out.println(binarySearch(arr,12));
        System.out.println(binarySearch(arr,5));
        System.out.println(binarySearch(arr1,1));
        System.out.println(binarySearch(arr1,7));
        System.out.println(binarySearch(arr1,90));



    }
}
