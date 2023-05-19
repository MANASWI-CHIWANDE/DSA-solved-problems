package com.company.recursion;

public class Keypad_Combination {
    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printComb(String s, int idx, String combination ){
        if(idx == s.length()){
            System.out.println(combination);
            return;
        }
        char currChar = s.charAt(idx);
        String mapping = keypad[currChar-'0'];
        for(int i = 0; i <mapping.length();i++){
            printComb(s,idx+1,combination+mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        String s = "23";
        printComb(s,0,"");
    }
}
