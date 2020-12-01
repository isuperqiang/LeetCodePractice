package com.richie.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richie on 2020.10.20
 */
public class Medium_560 {
    /**
     * 和为 K 的子数组
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * </p>
     *
     * <p>
     * 示例：
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * </p>
     *
     * <p>
     * 解答：前缀和+哈希表优化
     * 使用哈希表存储，key 为前缀和，value 为前缀和的个数。对于下标为 0 的元素，前缀和为 0，个数为 1。
     * 遍历数组，计算包括当前值的前缀和，获得前缀和为 preSum-k 的个数，因为 preSum-(preSum-k)=k，累加到计算变量里，然后用新的前缀和与个数更新哈希表。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * </p>
     */
    public static void main(String[] args) {
        int i = new Medium_560().subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(i); // 2
    }

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            Integer i = preSumMap.get(preSum - k);
            if (i != null) {
                count += i;
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
