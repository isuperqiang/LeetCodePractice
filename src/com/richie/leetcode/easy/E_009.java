package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2018.06.06
 */
public class E_009 {
    /**
     * 两数之和
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/two-sum/description/
     * </p>
     *
     * <p>
     * 描述：给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * </p>
     *
     * <p>
     * 解答：暴力遍历，寻找目标元素
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 5, 1};
        int[] ret = twoSum(nums, 7);
        System.out.println(Arrays.toString(ret));
        // [0， 2]
    }

    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}