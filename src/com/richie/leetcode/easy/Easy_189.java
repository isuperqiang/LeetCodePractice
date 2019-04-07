package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2018.05.30
 */
public class Easy_189 {
    /**
     * 旋转数组
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/rotate-array/description/
     * </p>
     *
     * <p>
     * 描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * - 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * - 要求使用空间复杂度为 O(1) 的原地算法。
     * </p>
     *
     * <p>
     * 解答：利用数组元素移动来实现，中间变量保存临时值
     * </p>
     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(a, k);
        System.out.println(Arrays.toString(a));
        // 输出 [5, 6, 7, 1, 2, 3, 4]
    }

    private static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[length - 1];
            for (int j = length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
