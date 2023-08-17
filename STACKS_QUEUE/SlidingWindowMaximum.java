package com.company.stackAndQueue;
/*
https://leetcode.com/problems/sliding-window-maximum/
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    class BruteForce{
        private void getMax(int[] nums,List<Integer>ans,int left,int right){
            int maxi = Integer.MIN_VALUE;
            for(int i =left;i<=right;i++){
                maxi=Math.max(maxi,nums[i]);
            }
            ans.add(maxi);
        }
        public int[] maxSlidingWindow(int[] nums, int k) {
            int left=0;
            int right=k-1;
            List<Integer>ans = new ArrayList<>();
            while(right< nums.length){
                getMax(nums,ans,left,right);
                left++;
                right++;
            }
            int []res = new int[nums.length-k+1];
            for (int ind =0;ind< ans.size();ind++){
                res[ind]= ans.get(ind);
            }
            return res;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int right=0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()==i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                ans[right++]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
