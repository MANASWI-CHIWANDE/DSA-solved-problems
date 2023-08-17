package com.company.stackAndQueue;

import java.util.Stack;

/*
https://leetcode.com/problems/basic-calculator/?envType=study-plan-v2&envId=top-interview-150
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval()
Example 1:
Input: s = "1 + 1"
Output: 2
 */
public class Easy_calculator {
    private static int precedence(char c){
        if(c=='+'||c=='-')return 1;
        else return -1;
    }
    public static String infixToPostfix(String exp) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> s = new Stack<>();
        for(int i =0;i<exp.length();i++){
            char c= ans.charAt(i);
            if(Character.isLetterOrDigit(c)){
                ans.append(c);
            }
            else if(c=='(') s.push(c);
            else if (c==')'){
                while(s.peek()!=')'&& !s.isEmpty()){
                    ans.append(s.pop());
                }
                s.pop();
            }
            else if(c==' ')continue;
            else{
                if(precedence(c)>=precedence(s.peek())){
                    s.push(c);
                }

            }
        }
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        return ans.toString();

    }
    private int evaluatePostfix(String s){
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char c= s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                int a = c;
                stack.push(a);
            }
            else{
                int second = stack.pop();
                int first = stack.pop();
                int ans =0;
                if(c=='+'){
                    ans=first+second;
                }
                else{ans = first-second;}
                stack.push(ans);
            }
        }
        return stack.pop();
    }
}
