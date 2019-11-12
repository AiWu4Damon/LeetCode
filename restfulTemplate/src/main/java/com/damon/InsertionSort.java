package com.damon;

/**
 * Insertion Sort
 * <br/>
 * 插入 排序
 * @author F88886
 * @date 2019/11/12 9:53
 */
public class InsertionSort {

    private static void insertSort(int[] a) {

        for (int index=1;index<=a.length-1;index++){
            int unsort = a[index];
            for (int i=index-1;i>=0;i--){
                int sort = a[i];
                if (unsort>sort){
                    break;
                }
                int temp = a[i+1];
                a[i+1] = a[i];
                a[i] =temp;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1,3,2,5,1,6,7,2,9,4};
        insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
