package github.zayn.leetcodexx.leetcode260;

/**
 * @ClassName SingleNumber3
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2022/12/7 11:24 AM
 **/
public class SingleNumber3 {

    public static void main(String[] args) {
        int[] req = new int[]{1, 1, 1, 2, 2, 5, 3, 3, 4, 4};
        int eor = 0;
        for (int k : req) {
            eor = eor ^ k;
        }
        //因为eor不是0，所以在二进制表示里肯定存在一位或几位是1.所以我们要找到这个最右边的1
        //二进制最快找这个1的方式
        int rightOne = eor & (-eor);
        int res1 = 0;
        for (int i : req) {
            if ((i & rightOne) == 0) {
                res1 = res1 ^ i;
            }
        }
        int res2 = eor ^ res1;
        System.out.println("res1 is " + res1 + ", res2 is " + res2);
    }
}
