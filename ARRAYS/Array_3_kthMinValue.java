package com.company.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Array_3_kthMinValue {
    public static void main(String[] args) {
        long a [] = { 12,34,44,2,44444,5566};
        Scanner sc =  new Scanner(System.in);
        int k  = sc.nextInt();
        Arrays.sort(a);
        System.out.println(a[k]);
    }
}
