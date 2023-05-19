package com.company.SearchingAndSorting;

public class Insertion_sort {
    public static void printArray(int arr[]){
        for (int ele : arr) {      System.out.print(ele + " ");      }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {55,33,22,11,44};
        for(int i = 1; i <arr.length ; i++){  // to track unsorted part
            int current = arr[i]; // 1st element in unsorted array
            int j = i-1;
            while (j >=0 && current <arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            //placement
            arr[j+1]=current;
        }
        printArray(arr);
    }
}
