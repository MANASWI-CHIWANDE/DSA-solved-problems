package com.company.recursion;

public class Permutation_String {
    public static void permutationString(String s , String permutation){
        if(s.length()==0){
            System.out.println(permutation);
            return;
        }
     for(int i = 0; i<s.length();i++){
         char currChar = s.charAt(i);
         //abc ->ab
         String newString =s.substring(0,i)+s.substring(i+1);
         permutationString(newString, permutation+currChar);
     }
    }
    public static void main(String[] args) {
        String str = "abc";
        permutationString(str,"");
    }
}
