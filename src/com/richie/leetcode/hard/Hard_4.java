package com.richie.leetcode.hard;

/**
 * @author Richie on 2020.04.03
 */
public class Hard_4 {
    /**
     * 寻找两个有序数组的中位数
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     * </p>
     *
     * <p>
     * 描述：
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * </p>
     *
     * <p>
     * 示例：
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * </p>
     *
     * <p>
     * 解答：
     *
     * </p>
     *
     * <p>
     * 时间复杂度：
     * 空间复杂度：
     * </p>
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        double result = (double) (nums1[nums1.length / 2] + nums2[nums2.length / 2]) / 2;
        return result;
    }
}
