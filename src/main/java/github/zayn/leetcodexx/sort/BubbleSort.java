package github.zayn.leetcodexx.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 4, 8, 7, 6};
        bubbleSortV3(arr);

        System.out.println(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 可以提前退出的冒泡
     *
     * @param arr
     * @return
     */
    private static void bubbleSortV2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            //提前退出冒泡循环标志位
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private static int[] bubbleSortV3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
