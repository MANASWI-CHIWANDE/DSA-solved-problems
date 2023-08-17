package com.company.SearchingAndSorting;

import java.util.Arrays;

public class MergeSort {
    static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int []left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int []right=mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    private static int[] merge(int[] first,int[] second){
        int[] mix = new int[first.length+ second.length];

        int i=0;int j=0;int k=0;

        while(i< first.length && j< second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else{
                mix[k]= second[j];
                j++;
            }
            k++;
        }
        //it may be possible that one of the arrays terminated
        //copy the remaining elemnets
        while(i< first.length){
            mix[k]=first[i];
            k++;i++;
        }
        while(j< second.length){
            mix[k]=second[j];
            k++;j++;
        }
        return mix;
    }

    static void mergeSort_Inplace(int[] arr,int start,int end){
        if(end-start==1)return;
        int mid = (start+end)/2;
        mergeSort_Inplace(arr,start,mid);
        mergeSort_Inplace(arr,mid,end);
        merge_Inplace(arr,start,mid,end);

    }
    private static void merge_Inplace(int[]arr, int start,int mid,int end){
        int[] mix = new int[end-start];

        int i=start;int j=mid;int k=0;

        while(i< mid && j< end){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            }
            else{
                mix[k]= arr[j];
                j++;
            }
            k++;
        }
        //it may be possible that one of the arrays terminated
        //copy the remaining elemnets
        while(i< mid){
            mix[k]=arr[i];
            k++;i++;
        }
        while(j<end){
            mix[k]=arr[j];
            k++;j++;
        }

        for(int l=0;l<mix.length;l++){
            arr[start+l]=mix[l];
        }
    }

    public static void main(String[] args) {
        int[]arr={5,4,3,2,1};
        int[] ans =mergeSort(arr);
        System.out.println(Arrays.toString(ans));

        mergeSort_Inplace(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));

    }
}
