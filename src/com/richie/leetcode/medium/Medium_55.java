package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.09.23
 */
public class Medium_55 {
    /**
     * 跳跃游戏
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/jump-game/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * </p>
     *
     * <p>
     * 解答：
     * 一个大前提：如果能到达某个位置，那么一定能到达它前面的所有位置。
     * 如果作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
     * 对每个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。如果能跳到最后，那么就成功了。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean b = canJump(nums);
        System.out.println(b); // true
    }

    private static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
