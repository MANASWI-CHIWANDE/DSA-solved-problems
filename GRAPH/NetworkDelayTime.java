package com.company.graph;

import java.util.*;

/*
https://leetcode.com/problems/network-delay-time/
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 */
public class NetworkDelayTime {
    class Pair{
        int a;int b;
        Pair(int a , int b){
            this.a=a;
            this.b=b;
        }
    }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        distance[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparing(p->p.b));
        pq.offer(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair cur=pq.peek();
            int node= cur.a;
            int time = cur.b;
            pq.poll();
            for(Pair p : adj.get(node)){
                int neighbour = p.a;
                int weight=p.b;
                if(distance[neighbour]>time+weight){
                    distance[neighbour]=time+weight;
                    pq.offer(new Pair(neighbour,time+weight));
                }
            }
        }
        int max =Integer.MIN_VALUE;
        for(int ele:distance){
            max=Math.max(max,ele);
        }
        if(max==Integer.MAX_VALUE)return -1;

        return max;
    }
}
