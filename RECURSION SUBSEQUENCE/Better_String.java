package com.company.recursion_subsequence;
//problem :https://practice.geeksforgeeks.org/problems/better-string/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=better-string
/*
Given a pair of strings, Geek wants to find the better string. The better string is the string having more number of distinct subsequences.
If both the strings have equal count of distinct subsequence then return str1.
Input:str1 = "gfg", str2 = "ggg"
Output: "gfg"
Explanation: "gfg" have 7 distinct subsequences whereas "ggg" have 4 distinct subsequences.
 */
public class Better_String {
    static int count=0;
    static  int recursion(int i , String s,String newString){
        if(i==s.length()){
            return count++;
        }
        recursion(i+1,s,newString+s.charAt(i));
        String  s1 = newString.substring(0,newString.length()-1);
        recursion(i+1,s,s1);
        return 0;
    }
    public static String betterString(String str1, String str2) {
        int c1=recursion(0,str1,"");
        int c2=recursion(0,str2,"");
        if(c1>c2)return str1;
        else if(c1<c2)return str2;
        else return str1;
    }
}
