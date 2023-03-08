package github.zayn.leetcodexx.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 4, 8, 7, 6};
        insertSort(arr);
        System.out.println(arr);
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int value = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
