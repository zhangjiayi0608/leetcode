package github.zayn.leetcodexx.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 4, 8, 7, 6};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        System.out.println(arr);
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
