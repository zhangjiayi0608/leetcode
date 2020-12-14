package com.zhangjiayi.leetcodexx.array.interview1001;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Stack;

/**
 * 面试题 10.01. 合并排序的数组
 * <p>
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Interview1001 {
    /**
     * 双指针干就完了 输出是要输出A就先把Acopy到数组A的后面
     *
     * @param A
     * @param m
     * @param B
     * @param n
     * @return
     */
    public int[] merge(int[] A, int m, int[] B, int n) {
        int[] sorted = new int[6];
        int index = 0;
        int indexA = 0, indexB = 0;
        while (index < (m + n)) {
            if (indexB >= n) {
                sorted[index] = A[indexA];
                index++;
                indexA++;
            } else if (indexA >= m) {
                sorted[index] = B[indexB];
                index++;
                indexB++;
            } else if (A[indexA] > B[indexB]) {
                sorted[index] = B[indexB];
                index++;
                indexB++;
            } else {
                sorted[index] = A[indexA];
                index++;
                indexA++;
            }

        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 3, 5, 5, 5, 5, 3, 4, 6, 6, 4};
        Interview1001 interview1001 = new Interview1001();
//        interview1001.merge(A, 3, B, 3);
        Stack stack = interview1001.deleteSameItems2(B);
        System.out.println(stack);
    }

    public Stack deleteSameItems(int[] array) {
        Stack stack = new Stack();
        stack.push(array[0]);
        int length = array.length;
        int indexA = 1, indexB = 2;
        while (indexB < length) {
            int curr = (int) stack.peek();
            if (curr == array[indexA] && array[indexB] == array[indexA]) {
                int c = indexB + 1;
                if (c == length) {
                    stack.pop();
                    break;
                }
            } else if (curr == array[indexA] && array[indexB] != array[indexA]) {
                stack.pop();
            } else {
                stack.push(array[indexA]);
            }
            indexA++;
            indexB++;
        }
        if ((int) stack.peek() == array[length - 1]) {
            stack.pop();
        } else {
            stack.push(array[length - 1]);
        }
        return stack;
    }

    public Stack deleteSameItems2(int[] array) {
        Stack stack = new Stack();
        stack.push(array[0]);
        int index = 1;
        int length = array.length;
        while (index < length) {
            int i = (int) stack.peek();
            if (i == array[index]) {
                while (i == array[index]) {
                    index++;
                    if (index==length){

                    }
                }
                stack.pop();
            } else {
                stack.push(array[index]);
                index++;
            }
        }
        return stack;
    }

}
