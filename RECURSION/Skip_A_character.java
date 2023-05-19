package com.company.recursion;

public class Skip_A_character {
    public static String skipAChar(String s,char c){
        return helper(s,c,"",0);
    }

    private static String helper(String s, char c,String newString,int i) {
        if(i==s.length()){
            return newString;
        }
        if(s.charAt(i)==c){
            return helper(s,c,newString,i+1);
        }
        newString= newString +s.charAt(i);
        return helper(s,c,newString,i+1);

    }
    public static String skipA_String(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("apple")){
            return s.substring(5);
        }
        return s.charAt(0)+skipA_String(s.substring(1));
    }
    public static String skipChar1(String s){
        if(s.isEmpty()){
            return "";
        }
        char ch= s.charAt(0);
        if(ch=='a'){
            return skipChar1(s.substring(1));
        }
        return ch+skipChar1(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(skipAChar("baccad",'a'));
        System.out.println(skipChar1("basdabdaa"));
        System.out.println(skipA_String("bsappledfg"));
    }
}
