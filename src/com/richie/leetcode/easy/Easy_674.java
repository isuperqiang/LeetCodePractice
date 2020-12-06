package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.12.06
 */
public class Easy_674 {
    /**
     * 最长连续递增序列
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
     * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
     * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：nums = [1,3,5,4,7]
     * 输出：3
     * 解释：最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
     * </p>
     *
     * <p>
     * 解答：
     * 遍历数组，比较相邻两个元素的大小，记录连续递增的子序列的长度，不断更新最大长度。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        int ans = new Easy_674().findLengthOfLCIS(nums);
        System.out.println(ans);
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int count = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
