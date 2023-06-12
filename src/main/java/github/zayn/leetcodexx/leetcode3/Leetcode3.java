package github.zayn.leetcodexx.leetcode3;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Leetcode3
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2023/5/18 8:56 PM
 **/
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        int size = s.length();
        int i = 0;
        int j = 0;
        while (i < size && j < size) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
                result = Math.max(result, j - i);
            }
        }
        return result;
    }

}
