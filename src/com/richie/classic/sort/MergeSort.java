package com.richie.classic.sort;

import java.util.Arrays;

/**
 * @author richie on 2018.07.17
 * 归并排序
 */
public class MergeSort {
    /**
     *
     */

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 7, 4, 9};
        System.out.println("排序前：" + Arrays.toString(a));
        sort(a, 0, a.length - 1, new int[a.length]);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    private static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }
}
