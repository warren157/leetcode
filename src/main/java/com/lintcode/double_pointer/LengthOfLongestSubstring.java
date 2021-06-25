package com.lintcode.double_pointer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rui.wang
 * @version 1.0
 * @description: TODO
 * @date 2021/6/25 9:51
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s ="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static Integer lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int maxLen = 0;
        int low =0;
        int fast=0;
        if(len==0) return maxLen;
        while(low<len && fast<len ) {
            if(!set.contains(s.charAt(fast))){
                set.add(s.charAt(fast++));
                maxLen=Math.max(maxLen,fast-low);
            }else{
                set.remove(s.charAt(low++));
            }
        }
        return maxLen;
    }
}
