package com.company.recursion_subsequence;
import java.util.*;
/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation: 1 + 2 + 4 = 7 , There are no other valid combinations.
 */
public class Combination_III {
    private void findCombination(List<List<Integer>> ans, List<Integer> ds,int target , int arrSize,int idx) {
        if(target==0 && arrSize==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(arrSize<0 || target<0){
            return;
        }
        for(int i =1;i<10;i++){
            ds.add(i);
            findCombination(ans, ds, target-i, arrSize-1, i+1);
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(ans,new ArrayList<>(),n,k,1);
        return ans;
    }
}
