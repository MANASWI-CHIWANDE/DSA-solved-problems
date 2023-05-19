package com.company.SearchingAndSorting;

public class Bubble_Sort {
    // Time Complexity = O(n^2)
    public static void main(String[] args) {
        int arr[]  = {55 ,33, 22 ,11, 44};
        //bubble sort
        //outer loop for n-1 iteration
        for(int i = 0; i<arr.length-1 ;i++){              // 1st iteration : 33 22 11 44 55
            for(int j = 0; j<arr.length-i-1 ; j++){       // 2nd iteration : 22 11 33 44 55
                if(arr[j] > arr[j+1]){                    // 3rd iteration : 11 22 33 44 55
                    int temp = arr[j];                    // 4th iteration : 11 22 33 44 55
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
