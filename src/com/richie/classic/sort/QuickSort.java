package com.richie.classic.sort;

import java.util.Arrays;

/**
 * @author richie on 2018.07.15
 * 快速排序
 */
public class QuickSort {
    /**
     *
     */

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 7, 1, 8};
        System.out.println("排序前：" + Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int pivot = nums[left];
            while (i < j) {
                while (i < j && nums[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] < pivot) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = pivot;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

}
