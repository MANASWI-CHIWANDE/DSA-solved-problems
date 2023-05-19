package com.company.strings;
//problem : https://leetcode.com/problems/merge-strings-alternately/
public class MergeStrings_Alternatively {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        StringBuilder res = new StringBuilder();
        int i =0;

        while(i <l1 && i <l2){
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
            i++;
        }

        res.append(word1.substring(i,l1));
        res.append(word2.substring(i,l2));
        return res.toString();
    }
}
