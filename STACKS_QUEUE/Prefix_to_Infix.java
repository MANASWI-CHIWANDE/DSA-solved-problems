package com.company.stackAndQueue;

import java.util.Stack;

public class Prefix_to_Infix {
    private static boolean isOperator(char c ){
        if(c=='+' || c=='-' || c=='/'|| c=='*'){
            return true;
        }
        else return false;
    }
    static String preToInfix(String pre_exp) {
        Stack<String> stack = new Stack<>();
        for(int i =pre_exp.length()-1;i>=0;i--){
            char c = pre_exp.charAt(i);
            if (isOperator(c)){
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String newExp = "("+operand1+c+operand2+")";
                stack.push(newExp);
            }
            else{
                stack.push(Character.toString(c));
            }
        }
        return stack.pop();
    }
}
