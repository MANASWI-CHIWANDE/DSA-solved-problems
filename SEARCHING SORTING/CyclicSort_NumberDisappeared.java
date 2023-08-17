package com.company.SearchingAndSorting;
import java.util.*;
/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 */
public class CyclicSort_NumberDisappeared {private void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
}

    // Method to find disappeared numbers in the array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // List to store the missing numbers
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int n = nums.length;

        // Iterate through the array
        while (i < n) {
            // Calculate the correct index for the current number
            int correct = nums[i] - 1;

            // Check if the number is in the correct position
            if (nums[i] != nums[correct]) {
                // Swap the current number with the number at the correct index
                swap(nums, i, correct);
            } else {
                // Move to the next element
                i++;
            }
        }

        // Iterate through the array to find missing numbers
        for (int j = 0; j < n; j++) {
            // If the number is not in the correct position, it is missing
            if (nums[j] != j + 1) {
                ans.add(j + 1);
            }
        }

        // Return the list of missing numbers
        return ans;
    }
}
