package com.company.SearchingAndSorting;

public class Selection_sort {
    //selection sort
    public static void printArray(int arr[]){
        for (int ele : arr) {      System.out.print(ele + " ");      }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {55,33,22,11,44};
        //time complexity  = O(n^2)
        for(int i = 0; i < arr.length -1; i++){
            int pos=i;
            for(int j = i+1 ; j < arr.length; j++){
                if(arr[pos] > arr[j]) pos = j;
            }
            int temp = arr[i];    // swapping
            arr[i] = arr[pos];
            arr[pos] = temp;
        }
        printArray(arr);
    }
}
