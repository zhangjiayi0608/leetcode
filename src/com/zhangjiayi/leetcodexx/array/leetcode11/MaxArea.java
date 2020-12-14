package com.zhangjiayi.leetcodexx.array.leetcode11;

/**
 * 双指针法
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            int max = min * (r - l);
            if (max > maxArea) {
                maxArea = max;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }


        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int num = maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(num);
    }
}
