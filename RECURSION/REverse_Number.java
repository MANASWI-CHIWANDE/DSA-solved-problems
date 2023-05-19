package com.company.recursion;

public class REverse_Number {
    static int sum=0;
    //way1
    static void recursion1(int n){
        if(n==0)return;
        sum=sum*10+n%10;
        recursion1(n/10);
    }
    static int recursion2(int n){
        int digit = (int)Math.log10(n)+1;
        return helper(n,digit);
    }

    private static int helper(int n, int digit) {
        if(n%10==n)return n;
        int rem = n%10;
        return rem *(int)Math.pow(10,digit-1) + helper(n/10,digit-1);
    }

    public static void main(String[] args) {
        int n =14365;
        recursion1(n);
        System.out.println(recursion2(n));
        System.out.println(sum);
    }
}
