package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2018.06.06
 */
public class E_010 {

    /**
     * 移动零
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/move-zeroes/description/
     * </p>
     *
     * <p>
     * 描述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 说明：必须在原数组上操作，不能拷贝额外的数组；尽量减少操作次数。
     * </p>
     *
     * <p>
     * 解答：采用快慢指针，快指针每次移位，把非零元素赋值给慢指针的位置，慢指针移位，最后，把慢指针剩下的位置赋值零。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        // [1, 3, 12, 0, 0]
    }

    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int i = slow; i < len; i++) {
            nums[i] = 0;
        }
    }
}
