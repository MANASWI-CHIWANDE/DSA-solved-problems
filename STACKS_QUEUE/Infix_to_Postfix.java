package com.company.stackAndQueue;

import java.util.Stack;

public class Infix_to_Postfix {
    private static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return  3;
        }

        return -1;
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
            else{
                if(precedence(c)>=precedence(s.peek())){
                    s.push(c);
                }
                else{
                    while(!s.isEmpty()&& precedence(c)<precedence(s.peek())){
                        ans.append(s.pop());
                    }
                    s.push(c);
                }
            }
        }
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        return ans.toString();

    }
}
