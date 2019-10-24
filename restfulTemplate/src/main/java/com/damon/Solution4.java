package com.damon;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
class Solution4 {
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int max = 1;
        int[] indexs=new int[2];
        //指针
        for (double pointer = 0.5; pointer <= s.length() - 1; pointer += 0.5) {
            double remain = pointer % 1;
            //指针在整数部分
            for (int start = (int) (pointer - 1 + remain), end = (int) (pointer + 1 - remain); start >= 0 && end <= s.length() - 1; start--, end++) {
                if (s.charAt(start) != s.charAt(end)) {
                    break;
                }
                if (end- start + 1 > max ){
                    max =end-start + 1;
                    indexs[0] =start;
                    indexs[1] =end;
                }
            }
        }
        return s.substring(indexs[0],indexs[1]+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}