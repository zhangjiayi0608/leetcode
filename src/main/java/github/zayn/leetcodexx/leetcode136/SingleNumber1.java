package github.zayn.leetcodexx.leetcode136;

/**
 * @ClassName SingleNumber3
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2022/12/7 11:24 AM
 **/
public class SingleNumber1 {

    public static void main(String[] args) {
        int[] req = new int[]{1, 1, 2, 2, 5, 3, 3, 4, 4};
        int i = singleNumber(req);
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

}
