package com.company.stackAndQueue;
import java.util.*;
public class NextGreaterElement_II {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        for(int i=0;i<2*n;i++){
            while(!stack.isEmpty()&& stack.peek()<=nums[i%n]){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty()){
                    nge[i]=-1;
                }
                else{
                    nge[i]= stack.peek();
                }
            }
            stack.push(nums[i%n]);
        }
        return nge;
    }
}
