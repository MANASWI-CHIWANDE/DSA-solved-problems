package com.company.SearchingAndSorting;

public class Cyclic_Sort {
    private static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    private static void cyclieSort(int[] arr){
        int i =0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr ={5,3,1,4,2};
        cyclieSort(arr);
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }
}
