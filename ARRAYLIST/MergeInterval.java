package com.company.arrayList;
import java.util.*;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
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
}
