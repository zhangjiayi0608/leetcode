package github.zayn.leetcodexx.heap;

/**
 * @ClassName Heap
 * @DESCRIPTION TODO
 * @Author zhangjiayi07
 * @Date 2023/5/9 4:45 PM
 **/
public class Heap {
    //存储堆的数组
    int[] a;
    //堆可以存储的最大数据个数
    int n;
    //当前已存储的个数
    int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    //堆中插入一个数字
    public void insert(int data) {
        //超出容量
        if (count >= n) {
            return;
        }
        count++;
        a[count] = data;
        int i = count;
        heapifyBottom2Top(a, i);
    }

    //自底向上构建堆  i，数组下标，a，数组
    public void heapifyBottom2Top(int[] a, int i) {
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    //删除堆顶
    public void deleteMax() {
        if (count <= 0) {
            return;
        }
        a[1] = a[count];
        count--;
        heapifyTop2Bottom(a, count, 1);
    }

    //自顶向下构建堆 a：堆 count：当前堆元素个数 i：数组下标
    private void heapifyTop2Bottom(int[] a, int count, int i) {
        //自上往下堆化
        while (true) {
            //堆顶位置
            int maxPos = i;
            //如果堆顶小于左边，maxPos记录左边的下标
            if (i * 2 <= count && a[maxPos] < a[i * 2]) {
                maxPos = i * 2;
            }
            //如果maxPos小于右边，maxPos记录右边的下标
            if (i * 2 + 1 <= count && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            //不用再换了，跳出循环
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }

    }

    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    /**
     * 构建堆（大顶堆）
     *
     * @param a
     * @param n
     */
    public void buildHeap(int[] a, int n) {
        //因为叶子节点往下堆化只能自己跟自己比较，所以我们直接从最后一个非叶子节点开始，依次堆化就行了
        //所以我们i是从n/2开始的。n/2是最后一个非叶子节点，n/2之后的节点都是叶子节点
        for (int i = n / 2; i >= 1; i--) {
            heapifyTop2Bottom(a, n, i);
        }
    }

    /**
     * 堆排序
     *
     * @param a
     * @param n
     */
    public void sort(int[] a, int n) {
        //先构建堆
        buildHeap(a, n);
        //
        int k = n;
        while (k > 1) {
            //每次把堆的最大值和k做交换，就相当于把最大的值挪到了最后面
            swap(a, 1, k);
            //接着k向前一位
            k--;
            //再接着从上往下堆化
            heapifyTop2Bottom(a, k, 1);
        }
    }

    public static void main(String[] args) {
        int n = 9;
        Heap heap = new Heap(n + 1);
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }
//        heap.buildHeap(a, n);
//        System.out.println(a);
        heap.sort(a,9);
        System.out.println(a);

    }
}
