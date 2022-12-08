package github.zayn.leetcodexx.array.leetcode704;

/**
 * @ClassName BanerySearch
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2022/12/8 11:49 AM
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int search = search(nums, 2);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

}
