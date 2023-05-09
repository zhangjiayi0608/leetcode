package github.zayn.leetcodexx.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PrintPermutations
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2023/5/8 8:08 PM
 **/
public class PrintPermutations {
    public static List<List<Integer>> printPermutations(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        printPermutationsHelper(nums, n, n, result);
        return result;
    }

    public static void printPermutationsHelper(int[] nums, int n, int k, List<List<Integer>> result) {
        if (k == 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nums[i]);
            }
            result.add(list);
        }
        for (int i = 0; i < k; i++) {
            swap(nums, i, k - 1);
            printPermutationsHelper(nums, n, k - 1, result);
            swap(nums, i, k - 1);
        }
    }


    public static void swap(int[] nums, int i, int j) {    //交换函数
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        List<List<Integer>> result = printPermutations(a);
        System.out.println(result);
    }
}
