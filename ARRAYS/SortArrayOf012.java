package com.company.arrays;

public class SortArrayOf012 {
    /*public static void sortArrayOf012(int num[]){
        int n = num.length;
        for ( int i=0;i<n-1;i++){
            for(int j= 0;j<n-i-1;j++){
                if(num[j]> num[j+1]){
                    int temp = num[j];
                    num[j]=num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }*/
    /*public static void sortArrayOf012(int num[]){
        int n = num.length, zeroCount=0 , oneCount=0, twoCount=0;
        for(int i = 0;i<n;i++){
            if(num[i]==0) zeroCount++;
            else if(num[i]==1) oneCount++;
            else twoCount++;
        }
        int k =0;
        for(int i =0;i<zeroCount;i++){ num[k++]=0;}
        for(int i =0;i<oneCount;i++){ num[k++]=1;}
        for(int i =0;i<twoCount;i++){ num[k++]=2;}
        for (int ele: num){
            System.out.print(ele +" ");
        }}*/
    public static void swap(int a , int b){
        int temp =0;
        temp = a;
        a=b;
        b=temp;
    }
    public static void sortArrayOf012(int nums[]){
        int n = nums.length ,low=0,mid =0,high = n-1;
        int temp=0;
        while(mid<=high){
            switch (nums[mid]) {
                case 0 -> {
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    mid++;
                    low++;
                }
                case 1 -> mid++;
                case 2 -> {
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                }
            }
        }
        System.out.println(low +" "+ mid+" "+high);
        for (int ele: nums){
            System.out.print(ele +" ");
        }
    }

    public static void main(String[] args) {
        int arr[]={0,0,1,1,1,1,1,0,0,0,2,2};
        sortArrayOf012(arr);
    }
}
