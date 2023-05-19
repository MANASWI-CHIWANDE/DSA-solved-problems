package com.company.arrays;

//reverse array
public class Array_1 {
    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args) {
        int [] arr = { 1,2,3,4,5,6};
        int start = 0;
        int end = arr.length -1;
        while(start<end){
            swap(arr[start],arr[end]);
            start++;
            end--;
        }

        for(int ele:arr){
            System.out.print(ele + " ");
        }
    }
}
