package github.zayn.leetcodexx.sort;

/**
 * @ClassName CountingSort
 * @DESCRIPTION 计数排序，一种类似桶排序的排序方法，适用于小数据量排序
 * @Author zhangjiayi07
 * @Date 2023/3/24 3:34 PM
 **/
public class CountingSort {
    public static void countingSort(int[] a) {
        int length = a.length;
        if (length <= 1) {
            return;
        }
        //查找数组中数据的范围 start
        int max = a[0];
        for (int i = 1; i < length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        //end
        //申请一个计数数组c,下标大小[0,max] start
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            c[i] = 0;
        }
        //end
        //计算每个数字的个数，并且塞进数组c中 start
        for (int i = 0; i < length; ++i) {
            c[a[i]]++;
        }
        //end
        //把数组c依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }
        //end
        //临时数组r，存储排序后的结果
        int[] r = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }
        //把数组r中的数据回写到a中
        System.arraycopy(r, 0, a, 0, length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 4, 8, 7, 6};
        countingSort(arr);
        System.out.println(arr);
    }
}
