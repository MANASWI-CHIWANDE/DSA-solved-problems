package com.company.arrays;

public class Kadanes_ALgorithm {
    public static int kadanes_algorithm(int []arr){
        int n = arr.length;
        int sum=0;
        int maxi = arr[0];
        for(int i =0;i<n;i++){
            sum+=arr[i];
            maxi = Math.max(maxi,sum);
            if(sum<0) sum =0;
        }
        return maxi;
    }
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(" the maximum sum of contiguous subarray is : "+ kadanes_algorithm(arr));

    }
}
