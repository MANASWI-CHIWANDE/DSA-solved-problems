package com.company.recursion;

public class SumOfDigit {
    static int recursion(int n,int sum){
        if(n==0){
            return sum;
        }
        sum =sum+ n%10;
        n=n/10;
        return recursion(n,sum);
    }
    public static void main(String[] args) {
        int n = 1342;
        System.out.println(recursion(1342,0));;
    }
}
