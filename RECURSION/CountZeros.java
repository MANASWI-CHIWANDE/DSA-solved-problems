package com.company.recursion;

public class CountZeros {
    public static int countZeros(int n){
        return helper(n,0);
    }

    private static int helper(int n, int c) {
        if(n==0){
            return c;
        }
        if(n%10==0){
            return helper(n/10,c+1);
        }
        return helper(n/10,c);
    }

    public static void main(String[] args) {
        System.out.println( countZeros(10202034));
    }
}
