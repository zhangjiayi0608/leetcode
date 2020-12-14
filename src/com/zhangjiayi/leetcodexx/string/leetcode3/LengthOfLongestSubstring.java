package com.zhangjiayi.leetcodexx.string.leetcode3;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    /**
     * leetcode  3
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int result = 0, i = 0, j = 0;
        while (i < n && j < n) {
            //try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

}
