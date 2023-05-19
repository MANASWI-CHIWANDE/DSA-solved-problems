package com.company.recursion;
//1st and last occurance of an element in a string
public class Occurance {
    public static int first = -1;
    public static int last = -1;
    public static void findOccurence(String s , int idx, char element){
        if(idx == s.length()){
            System.out.print("first ocuurence at "+first+" and last occurance at "+last);
            return;
        }
        char currentChar = s.charAt(idx);
        if(currentChar == element){
            if(first == -1) first = idx;
            else last = idx;
        }
        findOccurence(s ,idx+1,element);
    }
    public static void main(String[] args) {
        String s = "abcaakjferncaajijnfANWJakmnd";
        findOccurence(s,0,'a');
    }
}
