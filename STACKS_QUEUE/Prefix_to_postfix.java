package com.company.stackAndQueue;

import java.util.Stack;

/*
Input:*-A/BC-/AKL
Output: ABC/-AK/L-*
 */
public class Prefix_to_postfix {
    static String preToPost(String pre_exp) {
        Stack<String> s=new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char c =pre_exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(Character.toString(c));
            }
            else{
                String operand1=s.pop();
                String operand2=s.pop();
                String newString=operand1+c+operand2;
                s.push(newString);
            }
        }
        return s.pop() ;
    }
}
