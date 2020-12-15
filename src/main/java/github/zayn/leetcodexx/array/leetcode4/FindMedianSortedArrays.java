package github.zayn.leetcodexx.array.leetcode4;


public class FindMedianSortedArrays {
    /**
     * leetcode 4 寻找两个有序数组的中位数
     * 暴力法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2 + 1]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2 + 1]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        int count = 0;
        int i = 0, j = 0;
        while (count != m + n) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums2[j++];
                }
            }
        }
        if (nums1[i] < nums2[j]) {
            nums[count++] = nums1[i++];
        } else {
            nums[count++] = nums2[j++];
        }
        if (count % 2 == 0) {
            return (nums[n / 2 - 1] + nums[n / 2 + 1]) / 2.0;
        } else {
            return nums[n / 2];
        }
    }

    /**
     * leetcode 4 寻找两个有序数组的中位数
     * 递归
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;

    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //保证了len1一直最小
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        //len1没了，只有len2，结果就是num2的第k个
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }


}

