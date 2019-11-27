package com.damon;

/**
 * ShellSort
 * <br/>
 *
 * @author F88886
 * @date 2019/11/13 9:27
 */
public class ShellSort {

    public static void main(String[] args) {
        int a[] = {1,4,2,5,6,1,4,5,9,3};
        shellSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 插入排序
     * @param a
     */
    private static void shellSort(int a[]) {
        for (int unsort=1;unsort<a.length;unsort++){
            int unsortItem = a[unsort];
            for (int sort = unsort-1;sort>=0;sort--){
                int sortItem = a[sort];
                if (unsortItem>sortItem){
                    break;
                }
                int temp = a[sort+1];
                a[sort+1] = a [sort];
                a[sort] = temp;
            }
        }
    }



}
