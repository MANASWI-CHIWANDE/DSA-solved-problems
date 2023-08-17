package com.company.graph;
/*
https://practice.geeksforgeeks.org/problems/word-ladder-ii/1
Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find all shortest transformation sequence(s) from startWord to targetWord. You can return them in any order possible.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList.
Return an empty list if there is no such transformation sequence.


Example 1:

Input:
startWord = "der", targetWord = "dfs",
wordList = {"des","der","dfr","dgt","dfs"}
Output:
der dfr dfs
der des dfs
Explanation:
The length of the smallest transformation is 3.
And the following are the only two ways to get
to targetWord:-
"der" -> "des" -> "dfs".
"der" -> "dfr" -> "dfs".
 */

import java.util.*;

public class WordLadder_II {
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList(wordList));

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level =0;

        while(!q.isEmpty()){
            ArrayList<String> vec = q.peek();
            q.poll();
            if(vec.size()>level){
                level++;
                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }
            String word = vec.get(vec.size()-1);
            if(word.equals(targetWord)){
                if(result.size()==0){
                    result.add(vec);
                }
                else if(result.get(0).size()==vec.size()){
                    result.add(vec);
                }
            }

            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i]=c;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return result;
    }
}
