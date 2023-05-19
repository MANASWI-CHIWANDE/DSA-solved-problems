package com.company.bitManipulation;

public class Bits {
    public static void getBit(int n , int pos){
        int bitMask = 1<<pos;
        if((bitMask & n) == 0){
            System.out.println("bit was zero");
        }
        else{
            System.out.println("bit was one");
        }
    }
    public static void setBit(int n , int pos){
        int bitMask = 1<<pos;
        int newNumber = bitMask | n;
        System.out.println(newNumber);
    }

    public static void clearBit(int n , int pos){
        int bitMask = 1<<pos;
        int notBitMask =~bitMask;
        int newNumber = notBitMask & n;
        System.out.println(newNumber);
    }
    public static void updateBit(int n , int pos , int oprn){
        if(oprn == 1) setBit(n,pos);
        else clearBit(n,pos);
    }
    public static void main(String[] args) {
        int n =5;
        int pos = 2;
        getBit(n,pos);
        setBit(5,1);
        clearBit(n,pos);
        updateBit(5,2,0);
        updateBit(5,1,1);
    }
}
