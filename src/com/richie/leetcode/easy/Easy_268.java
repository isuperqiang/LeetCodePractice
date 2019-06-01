package com.richie.leetcode.easy;

/**
 * @author richie on 2019.06.01
 */
public class Easy_268 {
    /**
     * 缺失数字
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/missing-number/
     * </p>
     *
     * <p>
     * 描述：给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     * <p>
     *
     * <p>
     * 示例：
     * 输入: [3,0,1]
     * 输出: 2
     * </p>
     *
     * <p>
     * 解答：
     * - 解法一：用完整数组的元素之和减去当前数组的元素之和就可以了。
     * - 解法二：异或操作，eg: b^a^b=a; 相同的数字互相抵消，剩下的数值就是结果
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int i = missingNumber2(nums);
        System.out.println(i); // 2
    }

    private static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numSum = 0;
        int allSum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            numSum += nums[i];
            allSum += i;
        }
        return allSum - numSum;
    }

    private static int missingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            result ^= i;
        }
        return result;
    }
}
