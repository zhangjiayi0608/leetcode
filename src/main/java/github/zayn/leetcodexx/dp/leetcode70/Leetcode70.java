package github.zayn.leetcodexx.dp.leetcode70;

import java.util.HashMap;
import java.util.Map;

public class Leetcode70 {

    /**
     * 散列表
     */
    private Map<Integer, Integer> hasSolvedList = new HashMap<>();

    /**
     * leetcode 70 爬楼梯
     * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     * <p>
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
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

    /**
     * 添加散列表
     * 爬楼梯
     * @param n
     * @return
     */
    public int climbStairsV3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (hasSolvedList.containsKey(n)) {
            return hasSolvedList.get(n);
        }
        int res = climbStairsV3(n - 1) + climbStairsV3(n - 2);
        hasSolvedList.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        Leetcode70 leetcode70 = new Leetcode70();
        int num = leetcode70.climbStairsV2(10);
        int num2 = leetcode70.climbStairs(10);
        int num3 = leetcode70.climbStairs(10);
        System.out.println(num);
    }


}
