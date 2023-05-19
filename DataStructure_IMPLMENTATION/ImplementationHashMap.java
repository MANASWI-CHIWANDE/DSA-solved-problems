package com.company.implementation;

import java.util.*;

public class ImplementationHashMap {
    static class HashMap<K,V>{// generics (when we are not sure about data types we add generics i.e. value inside angular brackets)
        // to create node for linkedlist
        private class Node{
            K key;
            V value;
            //this is a constructor for Node class
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n ;//number of nodes in linkedlist
        private int N ;//size of array buckets.length
        //same as private int arr[];
        private LinkedList<Node> buckets[];// this is our hashmap ARRAY OF LINKEDLIST

        //constructor of HashMap class
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for(int i =0;i<4;i++){
                this.buckets[i]= new LinkedList<>();// for creating null linkedlist at each bucket index
            }
        }

        private int hashFunction(K key){// to get bucket index
            // bucket index will always be +ve and will always lie between 0 to N-1
            int bi = key.hashCode();
            return Math.abs(bi)%N;
        }
        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i =0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;//di
                }
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            for(int i =0;i<N*2;i++){
                buckets[i]= new LinkedList<>();
            }
            for(int i =0 ;i<oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j =0 ;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){
            int bi = hashFunction(key);// to get bucket index
            int di = searchInLL(key,bi);// to get index of linkedlist
            if(di==-1){// key doesnt exist
                buckets[bi].add(new Node(key,value));
                n++;
            }
            else{// key already exist
                Node node = buckets[bi].get(di);
                node.value=value;
            }

            double lambda = (double) n/N;
            if(lambda>2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key);// to get bucket index
            int di = searchInLL(key,bi);// to get index of linkedlist
            if(di==-1){// key doesnt exist
                return false;
            }
            else{// key already exist
                return true;
            }
        }
        public V get(K key){
            int bi = hashFunction(key);// to get bucket index
            int di = searchInLL(key,bi);// to get index of linkedlist
            if(di==-1){// key doesnt exist
                return null;
            }
            else{// key already exist
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }
        public V remove(K key){
            int bi = hashFunction(key);// to get bucket index
            int di = searchInLL(key,bi);// to get index of linkedlist
            if(di==-1){// key doesnt exist
                return null;
            }
            else{// key already exist
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;

            }
        }
        public boolean isEmpty(){
            return n==0;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i< buckets.length;i++){//bi
                LinkedList<Node> ll = buckets[i];
                for(int j =0;j<ll.size();j++){//di
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("India",190);
        map.put("China",200);
        map.put("USA",130);
        map.put("sri lanka",90);
        map.put("Nepal",50);

        ArrayList<String> keys = map.keySet();
        for(int i=0;i< keys.size();i++){
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
    }
}
