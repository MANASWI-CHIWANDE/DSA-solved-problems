package com.company.graph;
/*
https://practice.geeksforgeeks.org/problems/graph-and-vertices/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=graph-and-vertices
Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.

Example 1:
Input: 2
Output: 2
Example 2:
Input: 5
Output: 1024
 */
public class Graph_and_vetrices {
    static int factorial(int n){
        if(n==0 || n==1)return 1;
        return n*factorial(n-1);
    }
    static long count(int n) {
        long power  = factorial(n)/(2*factorial(n-2));
        long ans  = (long) Math.pow(2,power);
        return ans;
    }
}
