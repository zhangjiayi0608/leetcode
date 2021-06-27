package github.zayn.leetcodexx.dp.leetcode70;

public class Leetcode70 {

    /**
     * leetcode 70 爬楼梯
     *
     * @param n
     * @return
     */

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsV2(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return climbStairsV2(n - 1) + climbStairsV2(n - 2);
        }
    }

    public static void main(String[] args) {
        Leetcode70 leetcode70 = new Leetcode70();
        int num = leetcode70.climbStairsV2(10);
        int num2 = leetcode70.climbStairs(10);
        System.out.println(num);
    }


}
