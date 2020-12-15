package github.zayn.leetcodexx.dp.leetcode5;

public class LongestPalindrome {


    /**
     * 先反向构建一个字符串，最大回文串是反向子串和最长公共子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int length = s.length();
        int max = 0;
        int end = 0;
        int[][] dp = new int[length][length];
        String reverse = new StringBuffer(s).reverse().toString();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                //比较是不是一个字符串
                if (dp[i][j] > max) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + dp[i][j] - 1 == i) {
                        max = dp[i][j];
                        end = i;
                    }
                }
            }
        }
        return s.substring(end - max + 1, end + 1);
    }


    /**
     * 先暴力解吧
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        int max = 0;
        String result = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring) && substring.length() > max) {
                    result = substring;
                    max = substring.length();
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 扩展中心法
     * 先找一个字符当做中心向左右两边发散
     * or找两个字符中间当做中心向两边发散
     *
     * @param
     */
    public String longestPalindrome3(String s) {
        int length = s.length();
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            //找一个字符当中心向两边发散
            int len1 = expanderCenter(s, i, i);
            //找两个字符中间档中心向两边发散
            int len2 = expanderCenter(s, i, i + 1);
            max = Math.max(len1, len2);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + (max - 1) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expanderCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l > 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l + 1;
    }


    public static void main(String[] args) {
        String a = "babad";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = longestPalindrome.longestPalindrome3(a);
        System.out.println(s);
    }

}
