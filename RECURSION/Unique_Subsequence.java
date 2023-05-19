package com.company.recursion;

import java.util.HashSet;

public class Unique_Subsequence {
    public static void uniqueSubsequence(String s, int idx , String newString , HashSet<String> newset){
        if(idx == s.length()){
            if(newset.contains(newString)) return;
            newset.add(newString);
            System.out.println(newString);
            return;
        }
        char currChar = s.charAt(idx);

        //to be
        uniqueSubsequence(s,idx+1,newString+currChar, newset);
        //not to be
        uniqueSubsequence(s,idx+1,newString,newset);
    }
    public static void main(String[] args) {
        String s = "aaa";
        HashSet<String> set = new HashSet<>();
        uniqueSubsequence(s,0,"",set);
    }

}
