package com.richie.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author richie on 2018.06.06
 */
public class Easy_1 {
    /**
     * 两数之和
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/two-sum/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * </p>
     *
     * <p>
     * 示例：
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * </p>
     *
     * <p>
     * 解答：
     * - 暴力法，遍历每个元素，寻找和为目标元素的两元素
     * - 哈希表法，空间换时间，value 记录下标，key 记录数值，遍历时比较
     * </p>
     *
     * <p>
     * 暴力法：
     * - 时间复杂度：O(N^2)
     * - 空间复杂度：O(1)
     * 哈希表法：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 5, 1};
        int[] ret = twoSum2(nums, 7);
        System.out.println(Arrays.toString(ret)); // [0， 2]
    }

    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}