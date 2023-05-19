package com.company.matrices;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_Intervals {
    public static int[][] mergeIntervals(int[][] intervals){
        //first we have to sort the array
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> list = new ArrayList<>();

        for(int[] interval : intervals){
// if arraylist is empty or if end of previous interval is less than start of current interval we will add the interval
            if(list.isEmpty() || list.get(list.size()-1)[1]<interval[0]){
                    list.add(interval);
            }
            else{
                list.get(list.size()-1)[1] = Math.max(interval[1],list.get(list.size()-1)[1]);
            }
        }
        int n = list.size();
        return list.toArray(new int[n][]);

    }
    public static void main(String[] args) {
        int intervals[][]= {{1,3},{2,6},{15,18},{8,10}};
        mergeIntervals(intervals);

    }
}

