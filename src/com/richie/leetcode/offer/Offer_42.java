package com.richie.leetcode.offer;

/**
 * @author Richie on 2020.12.23
 */
public class Offer_42 {
    /**
     * 连续子数组的最大和
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * </p>
     *
     * <p>
     * 解答：
     * 和题目 53 相同
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = new Offer_42().maxSubArray(nums);
        System.out.println(ans);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(sum, max);
        }
        return max;
    }
}
