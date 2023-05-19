package com.company.recursion;

public class Example {
    public static void printNumb(int n){
        if(n==0) {
            System.out.println();
            return;
        }
        System.out.print(n+ " ");
        printNumb(n-1);
    }
    static int sum(int n){
        if(n==0)return 0;
        return n+sum(n-1);
    }
    public static void NumbReverse(int n){
        if(n==0){
            System.out.println();
            return;
        }
        System.out.print(n+" ");
        NumbReverse(n-1);
    }
    public static void Numb(int i,int n){
        if(i>n){
            System.out.println();
            return;
        }
        System.out.print(i+" ");
        Numb(i+1,n);
    }
    public static void main(String[] args) {
        int n=5;
        printNumb(5);
        Numb(1,5);
        NumbReverse(n);
        System.out.println(sum(n));
    }
}
