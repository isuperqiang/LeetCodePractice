package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2018.06.05
 */
public class Easy_136 {
    /**
     * 只出现一次的数字
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/single-number/description/
     * </p>
     *
     * <p>
     * 描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * </p>
     *
     * <p>
     * 解答：若该数组有序，且某个元素只出现一次，以步数2向后遍历，那么一定会存在a[i] != a[i+1]。
     * </p>
     */

    public static void main(String[] args) {
        int[] a = {2, 2, 4, 4, 5};
        int i = singleNumber(a);
        System.out.println(i);
        // 5
    }

    private static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i = i + 2) {
            if (i + 1 >= len) {
                return nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
