package com.richie.leetcode.offer;

/**
 * @author Richie on 2021.01.05
 */
public class Offer_03 {
    /**
     * 数组中重复的数字
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 找出数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     * </p>
     *
     * <p>
     * 解答：
     * - 使用 Set 记录，不多解释
     * - 原地交换
     * 根据题意，如果出现重复数字，必有 nums[i]!=i。遍历数组并通过交换操作，使得元素的索引和值一一对应。
     * 如果索引 nums[i] 处和索引 i 处的元素值都为 nums[i]，即找到一组重复值。
     * </p>
     *
     * <p>
     * 原地交换：
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int ans = new Offer_03().findRepeatNumber(nums);
        System.out.println(ans);
    }

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0, len = nums.length; i < len; ) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
