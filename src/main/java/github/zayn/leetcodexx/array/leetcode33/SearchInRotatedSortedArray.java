package github.zayn.leetcodexx.array.leetcode33;

/**
 * @ClassName SearchInRotatedSortedArray
 * @DESCRIPTION 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * @Author zhangjiayi07
 * @Date 2021/6/29 8:20 下午
 **/
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int end = length - 1;
        int result = -1;
        if (nums[0] <= target) {
            for (int i = 0; i < length; i++) {
                if (nums[i] == target) {
                    result = i;
                }
            }
        } else if (nums[end] >= target) {
            for (int j = length - 1; j > 0; j--) {
                if (nums[j] == target) {
                    result = j;
                }
            }
        } else {
        }
        return result;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int search = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        System.out.println(search);
    }
}
