package com.company.recursion_subsequence;
import java.util.*;

public class Checking_Paranthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        recursion(0,0,n,"",list);
        return list;
    }
    static void recursion(int open,int close,int n,String s, ArrayList<String> list){
        if(s.length()==2*n){
            list.add(s);
            return;
        }
        if(open<n){
            String temp = s;
            temp = temp+"(";
            recursion(open+1, close, n, temp, list);
        }
        if(open>close){
            String temp = s;
            temp = temp+")";
            recursion(open, close+1, n, temp, list);
        }
    }
}
