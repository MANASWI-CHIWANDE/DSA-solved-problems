package com.company.recursion_subsequence;
import java.util.*;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombination {
    private static final HashMap<Character,String> phone = new HashMap<>();
    static {
        phone.put('2',"abc");
        phone.put('3',"def");
        phone.put('4',"ghi");
        phone.put('5',"jkl");
        phone.put('6',"mno");
        phone.put('7',"pqrs");
        phone.put('8',"tuv");
        phone.put('9',"wxyz ");
    }
    private void findCombination(List<String> ans, String digits,StringBuilder newString,int idx){
        if(digits.isEmpty()||idx==digits.length()){
            ans.add(newString.toString());
            return;
        }
        char digit = digits.charAt(idx);
        String letters = phone.get(digit);
        for (int i=0;i<letters.length();i++) {
            newString.append(letters.charAt(i));
            findCombination(ans,digits,newString,idx+1);
            newString.deleteCharAt(newString.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        return ans;
    }
}

