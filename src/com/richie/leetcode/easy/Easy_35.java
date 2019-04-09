package com.richie.leetcode.easy;

/**
 * @author richie on 2019.04.09
 */
public class Easy_35 {
    /**
     * 搜索插入位置
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/search-insert-position/
     * </p>
     *
     * <p>
     * 描述：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * </p>
     *
     * <p>
     * 解答：因为是排序的数组，直接从头遍历，然后找到大于或者等于目标值的索引，就是结果。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
