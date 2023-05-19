package com.company.recursion;

public class Remove_Duplicates {
    public static boolean []map = new boolean[26]; //declaring maps
    public static void removeDupicate(String s, int idx , String newString){
        if(idx == s.length()){
            System.out.println(newString);
            return;
        }
        char currChar = s.charAt(idx);
        if(map[currChar-'a']){
            removeDupicate(s,idx+1, newString);
        }
        else{
            newString+= currChar;
            map[currChar-'a'] =true;
            removeDupicate(s,idx+1,newString);
        }
    }
    public static void main(String[] args) {
        String s = "abbccda";
        removeDupicate(s,0,"");
    }
}
