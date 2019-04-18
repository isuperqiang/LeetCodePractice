package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2019.04.18
 */
public class Easy_88 {
    /**
     * 合并两个有序数组
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/merge-sorted-array/
     * </p>
     *
     * <p>
     * 描述：给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * </p>
     *
     * <p>
     * 解答：从右往左遍历，比较 nums1 和 nums2 的元素大小，然后从右边开始填充 nums1，不需要额外的存储空间。
     * </p>
     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(a, m, b, n); // [1,2,2,3,5,6]
        System.out.println("a: " + Arrays.toString(a));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }

        int p = m + n - 1;
        m -= 1;
        n -= 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[p--] = nums1[m--];
            } else {
                nums1[p--] = nums2[n--];
            }
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}
