package com.richie.leetcode.easy;

/**
 * @author richie on 2018.07.01
 */
public class Easy_53 {
    /**
     * 最大子序和
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * </p>
     *
     * <p>
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * </p>
     *
     * <p>
     * 解答：
     * - 贪心算法
     * 1. 遍历数组，当前最大子序和 sum，返回值 max
     * 2. 如果 sum<0，其对子序和的增加没有正面效果，需要舍弃，重置 sum 为 0,
     * 3. sum 加上当前值，并比较和 max 的大小，记录 max
     * - 动态规划
     * 1. 定义状态，dp[i] 表示从 0 到 i 的数组中的最大子序和
     * 2. 初始状态，dp[0] 就是第一个元素值 nums[0]
     * 3. 状态转移方程，如果 dp[i-1]<0，dp[i-1]+nums[i] 肯定小于 nums[i]，这时就要从 nums[i] 开始计数
     * 4. 比较每步的 dp[i]，并保存到 max，最后返回结果
     * </p>
     *
     * <p>
     * - 贪心算法：
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * - 动态规划
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = new Easy_53().maxSubArray(nums);
        System.out.println(max);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
