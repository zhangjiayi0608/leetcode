package com.zhangjiayi.leetcodexx.dp.leetcode152;

public class MaxProduct {

    /**
     * leetcode 152 乘积最大子序列
     *
     * @param nums
     * @return
     */

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
