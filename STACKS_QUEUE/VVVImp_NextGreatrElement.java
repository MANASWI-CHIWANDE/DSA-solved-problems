package com.company.stackAndQueue;
/*
https://leetcode.com/problems/next-greater-element-i/
Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 */
class Solution{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] result =new int[n1];
        for(int i =0;i<n1;i++){
            for(int j=0;j<n2;j++){
                while(nums1[i]!=nums2[j]){
                    j++;
                }

            }
        }
        return result;
    }
}
public class VVVImp_NextGreatrElement {
}
