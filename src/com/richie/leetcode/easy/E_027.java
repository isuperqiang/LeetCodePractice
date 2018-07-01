package com.richie.leetcode.easy;

/**
 * @author richie on 2018.07.01
 */
public class E_027 {
    /**
     * 最大子序和
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/maximum-subarray/description/
     * </p>
     *
     * <p>
     * 描述：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * </p>
     *
     * <p>
     * 解答：求和，然后判断和是否小于0。因为只要前面的和小于0，那么后面的数加上前面的和就一定比自身小，所以又重新求和，并和之前的最大子序和比较，取最大值。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(nums);
        System.out.println(max);
        // 6
    }

    private static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
