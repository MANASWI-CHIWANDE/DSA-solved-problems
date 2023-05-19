package com.company.recursion;

public class Reverse_String {
    public static void printRev(String s, int idx){
        if(idx == 0){
            System.out.print(s.charAt(idx));
            return ;
        }
        System.out.print(s.charAt(idx));
        printRev(s,idx-1);
    }
    public static void main(String[] args) {
        String str = "abcd";
        printRev(str,str.length()-1);
    }
}
