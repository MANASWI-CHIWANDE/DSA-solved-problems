package com.company.recursion_subsequence;
import java.util.ArrayList;
import java.util.List;

//problem:https://practice.geeksforgeeks.org/problems/generate-all-binary-strings/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=generate-all-binary-strings
/*
Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.
Input:N = 3
Output:000 , 001 , 010 , 100 , 101
 */
public class BinarySubsequence {
    public static List<String> generateBinaryStrings(int n){
        ArrayList<String> arr=new ArrayList<>();
        recursion(0,n,"",arr);
        return arr;
    }
    public static void recursion(int i,int n, String s,ArrayList<String> arr){
        if(n==i){
            arr.add(s);
            return ;
        }
        s=s+"0";
        recursion(i+1,n,s,arr);
        s=s.substring(0,s.length()-1);
        if(s.length()!=0&&s.charAt(s.length()-1)=='1')return;
        s=s+"1";
        recursion(i+1,n,s,arr);

    }

}
