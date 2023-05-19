package com.company.pattern;

public class Pattern_Diamond {
    public static void main(String[] args) {
        int n = 4;
        //upper
        for(int i = 1; i<=n ;i++){
            //spaces
            for(int j =1; j <= n-i ; j++){
                System.out.print(" ");
            }
            //stars
            for(int j = 1; j<=2*i-1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //lower
        for(int i = n; i>=1 ;i--){
            //spaces
            for(int j =1; j <= n-i ; j++){
                System.out.print(" ");
            }
            //stars
            for(int j = 1; j<=2*i-1 ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
