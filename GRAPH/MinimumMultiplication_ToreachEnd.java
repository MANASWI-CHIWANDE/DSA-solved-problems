package com.company.graph;

import java.util.*;

/*
Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.

Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

Example 1:

Input:
arr[] = {2, 5, 7}
start = 3, end = 30
Output:
2
Explanation:
Step 1: 3*2 = 6 % 100000 = 6
Step 2: 6*5 = 30 % 100000 = 30
 */
public class MinimumMultiplication_ToreachEnd {
    class Pair{
        int node;int steps;
        Pair(int node,int steps){
            this.node=node;
            this.steps=steps;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        int[] distance = new int[100000];
        Arrays.fill(distance,100000);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,0));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int node = cur.node;
            int steps = cur.steps;
            if(node==end)return steps;
            for(int ele : arr){
                int nextNode = (node*ele)%100000;
                if(steps+1<distance[nextNode]){
                    distance[nextNode]=steps+1;
                    q.add(new Pair(nextNode,steps+1));
                }

            }
        }
        return -1;
    }
}
