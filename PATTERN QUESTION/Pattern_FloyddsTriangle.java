package com.company.pattern;

public class Pattern_FloyddsTriangle {
    public static void main(String[] args) {
        int n = 5;
        int a = 1;
        for(int i = 1 ; i <=5 ; i++) {
            for(int j = 1 ; j<=i; j++){
                System.out.print(a+" ");
                a++;
            }
            System.out.println();
        }
    }
}
