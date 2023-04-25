package github.zayn.leetcodexx.array.leetcode704;

/**
 * @ClassName BanerySearch3
 * @DESCRIPTION 查找最后一个值等于给定值的元素
 * @Author zhangjiayi07
 * @Date 2022/12/8 11:49 AM
 **/
public class BinarySearch3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5};
        int search = search(nums, 2);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int t = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                t = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return t;
    }

}
