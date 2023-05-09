package github.zayn.leetcodexx.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 4, 8, 7, 6};

        System.out.println(arr);
    }

    public static void mergeSort(int[] a) {
        int size = a.length;
    }

    private static void mergeSortHelper(int[] a, int s, int e) {
        if (s > e) {
            return;
        }
        int mid = s + (e - s) / 2;
        
    }


    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
