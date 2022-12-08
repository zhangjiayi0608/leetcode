package github.zayn.leetcodexx.leetcode137;

/**
 * @ClassName SingleNumber3
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2022/12/7 11:24 AM
 **/
public class SingleNumber2 {

    public static void main(String[] args) {
        int[] req = new int[]{2, 2, 3, 2};
        int i = singleNumber2(req, 1, 3);
        System.out.println(i);
    }

    public static int singleNumber2(int[] nums, int k, int m) {
        int res = 0;
        int[] helper = new int[32];
        for (int i : nums) {
            for (int j = 0; j < 32; j++) {
                helper[j] += ((i >> j) & 1);
            }
        }
        for (int x = 0; x < 32; x++) {
            if (helper[x] % m == k) {
                res |= (1 << x);
            }
        }
        return res;
    }

}
