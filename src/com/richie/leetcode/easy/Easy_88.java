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
     * 描述：
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * </p>
     *
     * <p>
     * 示例：
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     * </p>
     *
     * <p>
     * 解答：双指针
     * 从后向前遍历数组，使用指针 p1 和 p2 分别指向 nums1 和 nums2 的尾部元素，从尾部开始遍历并比较值。使用指针 p 指向合并后的数组尾端，
     * 每次遍历比较值后，填充到 nums1。遍历结束后，nums2 可能存在剩余元素，将其继续填充到 nums1 中。
     * </p>
     *
     * <p>
     * 时间复杂度：O(M+N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(a, m, b, n); // [1,2,2,3,5,6]
        System.out.println(Arrays.toString(a));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length < m || nums2.length < n) {
            return;
        }

        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 2;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }

        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }
}
