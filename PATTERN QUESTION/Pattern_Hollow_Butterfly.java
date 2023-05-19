package com.company.pattern;

public class Pattern_Hollow_Butterfly {
    public static void main(String[] args) {
        int n =4;
        //upper
        for(int i = 1 ; i <=n ;i++){
            System.out.print("*");
            if(i>=2) {
                for (int j = 1; j <= i - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            for(int j =1; j <=2*(n-i);j++){
                System.out.print(" ");
            }
            System.out.print("*");
            if(i>=2) {
                for (int j = 1; j <= i - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
        //lower
        for(int i = n ; i >=1 ;i--){
            System.out.print("*");
            if(i>=2) {
                for (int j = 1; j <= i - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            for(int j =1; j <=2*(n-i);j++){
                System.out.print(" ");
            }
            System.out.print("*");
            if(i>=2) {
                for (int j = 1; j <= i - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
