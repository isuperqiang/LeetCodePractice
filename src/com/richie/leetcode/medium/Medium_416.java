package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.05.16
 */
public class Medium_416 {
    /**
     * 分割等和子集
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/
     * </p>
     *
     * <p>
     * 描述：给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 注意:
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1, 5, 11, 5]
     * 输出: true
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     * </p>
     *
     * <p>
     * 解答：
     * 动态规划，转化为背包问题：N 个物品放到承重 sum/2 的背包里。dp[i][j] 表示存在前 i 个整数的子集，其和为 j。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N*k)，k 为数组和的一半
     * 空间复杂度：O(N*k)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }

    private static boolean canPartition(int[] nums) {
        if (nums == null) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
