package com.company.recursion;

import java.util.Locale;

public class Check_palindrome {
    static boolean check(int i,String s,int n){
        if(i>=n/2)return true;
        if(s.charAt(i)!=s.charAt(n-i-1))return false;
        else return check(i+1,s,n);
    }
    public static void main(String[] args) {
        String s ="abccba";
//        System.out.println(check(0,s,s.length()));
//        int x =121;
//        String s2 = Integer.toString(x);
//        System.out.println(s2);



    }
}
