package com.damon;

import org.springframework.util.StringUtils;

import java.util.*;


//找出其中不含有重复字符的 最长子串 的长度。
class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
       int max=1;
       int start=0;
       if (s.length()==0||s.length()==1){return s.length();}
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            String substring = s.substring(start, i);
            if (substring.contains(String.valueOf(c))){
                start +=substring.indexOf(String.valueOf(c))+1;
            }
            max = (i-start+1)>max?i-start+1:max;
        }
       return max;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }
}