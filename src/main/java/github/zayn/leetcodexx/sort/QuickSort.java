package github.zayn.leetcodexx.sort;

import java.util.Random;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 2, 8, 5, 4, 6};
        quickSort(arr);
    }

    public static void quickSort(int[] arr) {
        quickSortInternally(arr, 0, arr.length - 1);
        System.out.println(arr);
    }


    private static void quickSortInternally(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSortInternally(arr, left, partitionIndex - 1);
            quickSortInternally(arr, partitionIndex + 1, right);
        }
    }

    //获取分区点的函数
    private static int partition(int[] arr, int left, int right) {
        //设置基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }


    //随机法获取分区点的函数
    private static int randomPartition(int[] arr, int left, int right) {
        Random random = new Random();
        int r = random.nextInt(right - left) + left;
        swap(arr, right, r);
        return partition(arr, left, right);
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
