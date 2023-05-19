package com.company.backtracking;

public class PrintLinearly {
    static void printLinearly(int i,int n){
        if(i<1)return;
        printLinearly(i-1,n);
        System.out.print(i+" ");
    }
    static void printLinearlyReverse(int i,int n){
        if(i>n)return;
        printLinearlyReverse(i+1,n);
        System.out.print(i+" ");
    }
    public static void main(String[] args) {
        printLinearly(3,3);
        System.out.println();
        printLinearlyReverse(1,5);
    }
}
