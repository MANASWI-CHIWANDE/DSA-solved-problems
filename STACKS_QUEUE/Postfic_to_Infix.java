package com.company.stackAndQueue;

import java.util.Stack;

/*
Input:    ab*c+
Output:   ((a*b)+c)
 */
public class Postfic_to_Infix {
    private static boolean isOperator(char c){
        if(c=='+'||c=='-'||c=='*'||c=='/')return true;
        return false;
    }
    static String postToInfix(String exp) {
        Stack<String> stack =new Stack<>();
        for(int i =0;i<exp.length();i++){
            char c= exp.charAt(i);
            if(isOperator(c)){
                String secondOperand = stack.pop();
                String firstOperand = stack.pop();
                String newString = '('+firstOperand+c+secondOperand+')';
                stack.push(newString);
            }
            stack.push(Character.toString(c));
        }
        return stack.pop();
    }
}
