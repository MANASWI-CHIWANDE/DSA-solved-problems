package com.company.recursion_subsequence;

import java.util.ArrayList;

public class SubsequenceOfString {
    public static void Subseq(String s,String newString){
        if(s.isEmpty()){
            System.out.println(newString);
            return;
        }
        char ch=s.charAt(0);
        Subseq(s.substring(1),newString+ch);
        Subseq(s.substring(1),newString);
    }
    public static ArrayList<String> Subsequence(String s, String newString){
        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(newString);
            return list;
        }
        char ch = s.charAt(0);
        ArrayList<String> left = Subsequence(s.substring(1),newString+ch);
        ArrayList<String> right = Subsequence(s.substring(1),newString);
        left.addAll(right);
        return left;
    }
    public static void Subseq_withASCII(String s,String newString){
        if(s.isEmpty()){
            System.out.println(newString);
            return;
        }
        char ch=s.charAt(0);
        Subseq(s.substring(1),newString+ch);
        Subseq_withASCII(s.substring(1),newString +(ch+0));
        Subseq(s.substring(1),newString);
    }

    public static void main(String[] args) {
        Subseq_withASCII("abc","");
    }
}
