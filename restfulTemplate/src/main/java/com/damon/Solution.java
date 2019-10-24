package com.damon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] ints = {5,-9,-11,9,9,-4,14,10,-11,1,-13,11,10,14,-3,-3,-4,6,-15,6,6,-13,7,-11,-15,10,-8,13,-14,-12,12,6,-6,8,0,10,-11,-8,-2,-6,8,0,12,3,-9,-6,8,3,-15,0,-6,-1,3,9,-5,-5,4,2,-15,-3,5,13,-11,7,6,-4,2,11,-5,7,12,-11,-15,1,-1,-9,10,-8,1,2,8,11,-14,-4,-3,-12,-2,8,5,-1,-9,-4,-3,-13,-12,-12,-10,-3,6,1,12,3,-3,12,11,11,10};
        System.out.println(threeSum(ints));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> return0 = new ArrayList<List<Integer>>();
        //因为a+b+c=0 那么a,b,c中必定是正 负相加或者是 三个零相加
        //考虑第一种情况先把数组分为正 负 零三个数组再计算
        //正数组
        List<Integer> plusArray = new ArrayList<Integer>();
        //负数组
        List<Integer> minusArray = new ArrayList<Integer>();
        //零数组
        List<Integer> zeroArray = new ArrayList<Integer>();
        //遍历nums
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                plusArray.add(num);
            } else if (num < 0) {
                minusArray.add(num);
            } else {
                zeroArray.add(num);
            }
        }
        //开始查找
        for (int i = 0; i < plusArray.size(); i++) {
            int plus = plusArray.get(i);
            for (int j = 0; j < minusArray.size(); j++) {
                int minus = minusArray.get(j);
                if (plus + minus < 0) {
                    for (int i1 = i + 1; i1 < plusArray.size(); i1++) {
                        int last = plusArray.get(i1);
                        if (plus + minus + last == 0) {
                            List<Integer> o = new ArrayList<Integer>();
                            o.add(plus);
                            o.add(minus);
                            o.add(last);
                            return0.add(o);
                        }
                    }
                } else if (plus + minus > 0) {
                    for (int j1 = j + 1; j1 < minusArray.size(); j1++) {
                        int last = minusArray.get(j1);
                        if (plus + minus + last == 0) {
                            List<Integer> o = new ArrayList<Integer>();
                            o.add(plus);
                            o.add(minus);
                            o.add(last);
                            return0.add(o);
                        }
                    }
                } else {
                    if (zeroArray.size()>0) {
                        List<Integer> o = new ArrayList<Integer>();
                        o.add(plus);
                        o.add(minus);
                        o.add(0);
                        return0.add(o);
                    }
                }
            }
        }
        return0  = removeRepeatList(return0);
        //三个 零的情况
        int size = zeroArray.size();
        if (size >= 3) {
            List<Integer> o = new ArrayList<Integer>();
            o.add(0);
            o.add(0);
            o.add(0);
            return0.add(o);
        }
        return return0;
    }

    private static List<List<Integer>> removeRepeatList(List<List<Integer>>oldList){
        HashSet<Integer> repeartIndex = new HashSet<Integer>();
        for (int i = 0; i < oldList.size(); i++) {
            List<Integer> list = oldList.get(i);
            for (int i1 = i+1; i1 < oldList.size(); i1++) {
                List<Integer> list1 = oldList.get(i1);
                if (list.contains(list1.get(0))&&list.contains(list1.get(1))){
                    repeartIndex.add(i1);
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < oldList.size(); i++) {
            boolean flag =true;
            for (Integer index : repeartIndex) {
                if (index==i){
                    flag=false;
                    break;
                }
            }
            if (flag){
                lists.add(oldList.get(i));
            }
        }
        return lists;
    }

}