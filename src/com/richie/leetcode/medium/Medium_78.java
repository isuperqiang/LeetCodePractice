package com.richie.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Richie on 2019.06.30
 */
public class Medium_78 {
    /**
     * 子集
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/subsets/
     * </p>
     *
     * <p>
     * 描述：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     * </p>
     *
     * <p>
     * 解答：二进制和位运算。
     * 数组中的每个元素，都有两个状态：在子数组中和不在子数组中。所有状态的组合就是所有的子数组。
     * 遍历 000 到 111，也就是 0 到 7，判断每个比特位是否为 1，如果是 1，那么将对应数字加入子数组。
     *
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> subList;
        int resultLength = 1 << nums.length;
        List<List<Integer>> resultList = new ArrayList<>(resultLength);
        for (int i = 0, numsLength = nums.length; i < resultLength; i++) {
            subList = new ArrayList<>(numsLength);
            for (int j = 0; j < numsLength; j++) {
                if ((i >> j & 1) == 1) {
                    subList.add(nums[j]);
                }
            }
            resultList.add(subList);
        }
        return resultList;
    }
}
