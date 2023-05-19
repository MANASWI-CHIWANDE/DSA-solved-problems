package com.company.arrays;

import java.util.Arrays;

//Move all negative numbers to beginning and positive to end with constant extra space
public class Array_5 {

    public static void main(String[] args) {
        int []a = {-12, 11, -13, 15, 6, -7, 5, -3, -6};
        Arrays.sort(a);
        for (int ele:a) {
            System.out.print(ele+" ");
        }
    }
}
