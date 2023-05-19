package com.company.recursion_subsequence;

import java.util.*;

/*
131. Palindrome Partitioning
https://leetcode.com/problems/palindrome-partitioning/
Given a string s, partition s such that every substriof the partition is a palindrome. Return all possible palindrome partitioning of s.
Example 1:Input: s = "aab" , Output: [["a","a","b"],["aa","b"]]
         */
public class Palindrome_Partion {
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private void palindromePartitioning(String s ,List<List<String>> ans,List<String> ds,int start ) {
        if(start== s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i =start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                String substring = s.substring(start,i+1);
                ds.add(substring);
                palindromePartitioning(s,ans,ds,i+1);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        palindromePartitioning(s,ans,new ArrayList<>(),0);
        return ans;
    }

}
