package com.company.arrays;
import java.util.*;

public class DuplicateElement_in_Array {
    public static int duplicateElementInArray(int nums[]){
        /*//brutefroce
        Arrays.sort(nums);int a=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) {a= nums[i];}
        }
        return a;*/

        /*//better approach
        int []freqArray=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(freqArray[nums[i]]==0){freqArray[nums[i]]+=1;}
            else return nums[i];
        }
        return 0;*/
        return 0;
    }
    public static void main(String[] args) {
        int array[]={1,3,2,4,3};
    }
}
