package github.zayn.leetcodexx.backtrack.leetcode131;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PalindromePartitioning
 * @DESCRIPTION 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * @Author zhangjiayi07
 * @Date 2021/7/6 6:51 下午
 **/
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), s, 0);
        return results;
    }

    public void backtrack(List<List<String>> results, List<String> tempList, String s, int startIndex) {
        //终止的条件
        int length = s.length();
        if (startIndex == length) {
            results.add(new ArrayList<>(tempList));
        } else {
            int j = length - startIndex;
            for (int i = 1; i <= j; i++) {
                int endIndex = startIndex + i;
                String sub = s.substring(startIndex, endIndex);
                if (isPalindrome(sub)) {
                    tempList.add(sub);
                    backtrack(results, tempList, s, endIndex);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length - 1;
        while (low < high) {
            if (chars[low] != chars[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition solution = new PalindromePartition();
        List<List<String>> result = solution.partition("aab");
        System.out.println(result);


    }

}
