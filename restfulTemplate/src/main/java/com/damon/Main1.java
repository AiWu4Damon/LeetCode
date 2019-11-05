package com.damon;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * main1
 * <br/>
 *
 * @author F88886
 * @date 2019/11/1 19:04
 */
public class Main1 {

    public static void main(String[] args) {
        int a[] ={11,3,9,4,2,5,3,8,10};
        sort1(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    private static LinkedList<Integer> sortFast(int[] a) {
        if (a==null||a.length<=1){ return new LinkedList<>();}
        LinkedList<Integer> list = new LinkedList<>();
        list.add(a[0]);
        for (int i = 1; i < a.length; i++) {
            int item = a[i];
            if (list.size()==1){
                if (list.get(0)<item){
                    list.add(item);
                }else{
                    list.add(0,item);
                }
                continue;
            }
            if (list.getLast()<item){
                list.add(item);
                continue;
            }
            if (list.getFirst()>item){
                list.add(0,item);
                continue;
            }
            for (int i1 = 0; i1 < list.size()-1; i1++) {
                int itemList =list.get(i1);
                int itemListEnd =list.get(i1+1);
                if (itemListEnd>=item&&item>=itemList){
                    list.add(i1+1,item);
                    break;
                }
            }
        }
        return list;
    }

    /**
     * mark first element as sorted

     for each unsorted element X

     'extract' the element X

     for j = lastSortedIndex down to 0

     if current element j > X

     move sorted element to the right by 1

     break loop and insert X here
     * @param a
     */
    public static void sort1(int a[]){
        int temp;
        for (int i = 1; i < a.length; i++) {
            int right = a[i];
            for (int i1 = 0; i1 <= i-1; i1++) {
                int left =a[i1];
                if (right<left){
                    temp =a[i];
                    a[i] =a[i1];
                    a[i1] =temp;
                }
            }
        }
    }
}
