package com.richie.classic.sort;

import java.util.Arrays;

/**
 * @author richie on 2018.07.15
 * 冒泡排序
 */
public class BubbleSort {
    /**
     * 冒泡排序的基本思想就是：从无序序列头部开始，进行两两比较，根据大小交换位置，直到最后将最大（小）的数据元素交换到了无序队列的队尾，
     * 从而成为有序序列的一部分；下一次继续这个过程，直到所有数据元素都排好序。
     * <p>
     * 算法的核心在于每次通过两两比较交换位置，选出剩余无序序列里最大（小）的数据元素放到队尾。
     * <p>
     * 平均时间复杂度：O(n^2)，空间复杂度：O(1)，稳定的排序算法
     */

    public static void main(String[] args) {
        int[] a = {2, 9, 8, 3, 5};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a) {
        int len = a.length;
        boolean hasSorted = false;
        for (int i = 0; i < len - 1 && !hasSorted; i++) {
            hasSorted = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    hasSorted = false;
                    SortUtils.swap(a, j, j + 1);
                }
            }
        }

    }
}
