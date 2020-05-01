package com.richie.leetcode.medium;

/**
 * @author Richie on 2019.07.20
 */
public class Medium_152 {
    /**
     * 乘积最大子序列
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/maximum-product-subarray/
     * </p>
     *
     * <p>
     * 描述：给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * </p>
     *
     * <p>
     * 解答：动态规划。
     * 遍历数组，计算当前最大值，并不断更新当前最大乘积 max，当前最小乘积 min。由于存在负数，导致最大的变成最小的，最小的变成最大的。
     * 所以分两种情况讨论：
     * - nums[i] > 0 时，max = Max(max * nums[i], nums[i]); min = Min(min * num[i], num[i]);
     * - nums[i] < 0 时，max = Max(min * nums[i], nums[i]); min = Min(max * num[i], num[i]);
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int i = maxProduct(nums);
        System.out.println(i); // 6
    }

    private static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            ret = Math.max(ret, max);
        }
        return ret;
    }

}
