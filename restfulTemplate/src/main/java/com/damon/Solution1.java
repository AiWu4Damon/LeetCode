package com.damon;

import java.util.*;


//找出其中不含有重复字符的 最长子串 的长度。
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        Map<String, List<Integer>> stringListHashMap = new HashMap<String, List<Integer>>();
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            String key =String.valueOf(s.charAt(i));
            putIntoMap(stringListHashMap,key,i);
        }
        for (Map.Entry<String, List<Integer>> stringListEntry : stringListHashMap.entrySet()) {
            List<Integer> value = stringListEntry.getValue();
            if (value.size()>1){
                for (int i = 0; i < value.size(); i++) {

                }
            }
        }
        return 0;
    }
    private void putIntoMap(Map<String,List<Integer>> map, String key, Integer index){
        if (null==map.get("key")){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(index);
            map.put(key,list);
        }else{
            List<Integer> list = map.get(key);
            list.add(index);
        }
    }

    private boolean checkStr(String str) {
        HashSet<Character> charSet = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charSet.contains(c)){return false;}
            charSet.add(c);
        }
        return true;
    }
}