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
        int search = search(nums, 3);
        int search2 = search2(nums, 3, 0, nums.length - 1);
        System.out.println(search + "," + search2);
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

    public static int search2(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return search2(nums, target, mid + 1, right);
        } else if (nums[mid] > target) {
            return search2(nums, target, left, mid - 1);
        }
        return -1;
    }

}
