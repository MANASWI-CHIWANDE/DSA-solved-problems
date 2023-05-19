package com.company.backtracking;
//to print all possible arrangements of the given string
public class Backtracking {
    public static void printPermutation(String s, String permutation , int index){
        if(s.length()==0) System.out.println(permutation);
        for(int i =0;i<s.length();i++){
            char currChar = s.charAt(i);
            String newString = s.substring(0,i) + s.substring(i+1);
            printPermutation(newString , permutation+currChar,index+1);
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        printPermutation(str,"",0);
    }
}
//time complexity = n *n!