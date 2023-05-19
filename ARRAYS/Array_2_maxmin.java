package com.company.arrays;
//Find minimum and maximum element in an array
public class Array_2_maxmin {
    public static void main(String[] args) {
        long a [] = { 12,34,44,2,44444,5566};
        long n = a.length;
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for(int i = 0 ;i <n ;i ++){
            if(a[i] >max) max = a[i] ;
            if(a[i] < min) min = a[i] ;
        }
        System.out.println("max = " + max + "\nmin = "+min);
    }
}
