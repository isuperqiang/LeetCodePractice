package com.richie.classic.sort;

import java.util.Arrays;

/**
 * @author richie on 2018.07.15
 * 选择排序
 */
public class SelectionSort {
    /**
     * 选择出数组中的最小元素，将它与数组的第一个元素交换位置。
     * 再从剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
     * <p>
     * 平均时间复杂度：O(n^2)，空间复杂度：O(1)，不稳定的排序算法
     */

    public static void main(String[] args) {
        int[] a = {2, 9, 8, 3, 5};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void selectionSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            SortUtils.swap(a, i, min);
        }
    }

}
