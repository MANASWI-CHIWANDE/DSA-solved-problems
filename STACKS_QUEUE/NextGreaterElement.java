package com.company.stackAndQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problems/next-greater-element-i/
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for(int i = nums2.length-1;i>=0;i--){
            while(!stack.isEmpty()&& stack.peek()<nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1 );
            }
            else{
                map.put(nums2[i],stack.peek() );
            }
            stack.push(nums2[i]);
        }
        for(int i =0;i< nums1.length;i++){
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
