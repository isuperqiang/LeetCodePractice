package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2018.06.04
 */
public class E_007 {
    /**
     * 存在重复元素
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/contains-duplicate/description/
     * </p>
     *
     * <p>
     * 描述：给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * </p>
     *
     * <p>
     * 解答：先排序，再判断相邻元素是否相等。
     * </p>
     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        boolean b = containsDuplicate(a);
        System.out.println(b);
        // true
    }

    private static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}
