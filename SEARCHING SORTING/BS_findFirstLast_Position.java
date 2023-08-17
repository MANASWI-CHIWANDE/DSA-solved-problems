package com.company.SearchingAndSorting;
/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1]
You must write an algorithm with O(log n) runtime complexity.
Example 1:     Input: nums = [5,7,7,8,8,10], target = 8    ,    Output: [3,4]
 */
public class BS_findFirstLast_Position {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the leftmost position of the target
        int leftmost = findPosition(nums, target, true);
        if (leftmost == -1) {
            return result;
        }

        // Find the rightmost position of the target
        int rightmost = findPosition(nums, target, false);

        result[0] = leftmost;
        result[1] = rightmost;
        return result;
    }

    // Helper function to find the leftmost or rightmost occurrence of the target
    private int findPosition(int[] nums, int target, boolean leftmost) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int position = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                position = mid;
                if (leftmost) {
                    high = mid - 1;  // Search left side for leftmost occurrence
                } else {
                    low = mid + 1;   // Search right side for rightmost occurrence
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return position;
    }
}
