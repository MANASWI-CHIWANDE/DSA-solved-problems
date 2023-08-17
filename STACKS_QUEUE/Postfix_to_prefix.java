package com.company.stackAndQueue;

import java.util.Stack;

/*
Input: ABC/-AK/L-*
Output: *-A/BC-/AKL
 */
public class Postfix_to_prefix {
    static String postToPre(String post_exp) {
        Stack<String> s = new Stack<>();
        for(int i =0;i<post_exp.length();i++){
            char c =post_exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(Character.toString(c));
            }
            else{
                String operand1=s.pop();
                String operand2=s.pop();
                String newString = c+operand2+operand1;
                s.push(newString);
            }
        }
        return s.pop();
    }
}
