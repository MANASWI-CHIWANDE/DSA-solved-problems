package com.company.arrays;
// Question : https://leetcode.com/problems/powx-n/
public class powerFunction {
    /*TIME COMPLEXITY = O(n)
    public static double power(double x, int n ){
        double ans = 1;
        if(n==0 || x==1) ans = 1;
        else {
            for(int i=0;i<Math.abs(n);i++){
                ans = x*ans;
            }
            if(n>0) return ans;
            if(n<0) return 1/ans;
            }
        return 0;*/
    //TIME COMPLEXITY = O(log N)
    public static double power(double x, int n ){
        double ans = 1.0;
        long nn = n;
        if(nn<0) nn = -1*nn;
        while(nn>0){
            if(nn%2==1){
                ans = ans*x;
                nn=nn-1;
            }
            else{
                x= x*x;
                nn=nn/2;
            }
        }
        if(n<0) ans = (double)(1.0)/(double)(ans);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(power(2,10));
    }
}
