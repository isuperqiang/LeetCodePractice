package com.richie.leetcode.medium;


/**
 * @author Richie on 2020.12.02
 */
public class Medium_209 {
    /**
     * 长度最小的子数组
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * </p>
     *
     * <p>
     * 解答：双指针
     * 定义两个指针 left right 分别指向子数组的开始和结束位置，维护变量 sum 存储子数组的元素和。left right 初始为 0，每次迭代把 nums[right]
     * 加到 sum。如果 sum 大于 s，更新子数组的最小长度，并从 sum 中减去 nums[left]，同时 left 右移，迭代结束时 right 右移。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int ans = new Medium_209().minSubArrayLen(7, nums);
        System.out.println(ans);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = nums.length;
        while (right < len) {
            sum += nums[right];
            while (sum >= s) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
