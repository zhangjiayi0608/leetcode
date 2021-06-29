package github.zayn.leetcodexx.leetcode31;

/**
 * @ClassName NextPermutation 下一个排列
 * @DESCRIPTION [1, 5, 8, 4, 7, 6, 5, 3, 1]
 * @Author zhangjiayi07
 * @Date 2021/6/13 7:31 下午
 **/

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int small = Integer.MAX_VALUE;
        int big = Integer.MIN_VALUE;
        int i, j;
        i = j = length - 1;
        while (i > 0) {
            if (nums[i] <=
                    nums[i - 1]) {
                i--;
                continue;
            }
            small = nums[i - 1];
            break;
        }
        if (i == 0) {
            reverse(nums, i, length - 1);
            return;
        }
        while (j >= 0) {
            if (small >= nums[j]) {
                j--;
                continue;
            }
            break;
        }
        swap(nums, i - 1, j);
        reverse(nums, i, length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        while (nums[left] > nums[right] && left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] nums = new int[]{1, 1};
        solution.nextPermutation(nums);
        System.out.println(nums);
    }
}
