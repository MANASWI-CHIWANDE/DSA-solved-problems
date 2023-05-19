package com.company.pattern;

public class Pattern_InvertedHalfPyramid01 {
    public static void main(String[] args) {
        for(int i = 1; i <=4;i++){
            for (int j = 1 ; j<=4-i;j++){
                System.out.print(" ");
            }
            for(int j = 4-i+1; j <=4; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
