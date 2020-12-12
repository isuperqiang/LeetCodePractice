package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2020.05.14
 */
public class Medium_300 {
    /**
     * 最长上升子序列
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
     * </p>
     *
     * <p>
     * 描述：给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * </p>
     *
     * <p>
     * 说明:
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n^2) 。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * </p>
     *
     * <p>
     * 解答：动态规划
     * - dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度;
     * - dp[i] 等于在下标 i 之前严格小于 nums[i] 的所有状态值中的最大值 + 1;
     * - 每个元素都至少可以单独成为子序列，dp 中的最大值就是要求的结果。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = new Medium_300().lengthOfLIS(nums);
        System.out.println(length);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int ans = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
