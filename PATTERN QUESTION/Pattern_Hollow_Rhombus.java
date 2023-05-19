package com.company.pattern;
//has to be redone
public class Pattern_Hollow_Rhombus {
    public static void main(String[] args) {
        int n = 5;
        for(int i =n; i>=1 ; i--){
            for(int j =1; j<=n-i ;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=5; j++){
                if(i ==1|| i==5){
                    System.out.print("*");
                }
                System.out.println();
            }
            for(int j = 1 ; j<=n ; j++){
                if(2<=i && i<=4){
                    System.out.print("*");

                    System.out.print("*");
                }
                System.out.println();
            }

        }
    }
}
