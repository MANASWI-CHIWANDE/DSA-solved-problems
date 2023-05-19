package com.company.recursion;


public class Hanoi_Tower {
    public static void towerOfHanoi(int n,String src, String helper,String desn){
        if(n==1){
            System.out.println("transfer disk"+n+" from "+ src +" to " + desn);
            return;
        }
        towerOfHanoi(n-1,src,desn,helper);
        System.out.println("transfer disk"+n+"from "+src+" to "+helper);
        towerOfHanoi(n-1,helper,src,desn);
    }
    public static void main(String[] args) {
        int n=3;
        towerOfHanoi(n,"S","H","D");
    }
}
