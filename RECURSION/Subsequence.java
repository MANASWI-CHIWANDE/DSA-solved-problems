package com.company.recursion;

import java.util.HashSet;

public class Subsequence {
    public static void subsequence(String s, int idx , String newString){
        if(idx == s.length()){
            System.out.println(newString);
            return;
        }
        char currChar = s.charAt(idx);

        //to be
        subsequence(s,idx+1,newString+currChar);
        //not to be
        subsequence(s,idx+1,newString);
    }
    public static void main(String[] args) {
        String s = "abc";
        subsequence(s,0,"");
    }
}
