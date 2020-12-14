package com.zhangjiayi.leetcodexx.dp.leetcode53;

public class MaxSubArray {

    /**
     * leetcode 53 最大子序列和
     *
     * @param nums
     * @return
     */

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }
}
