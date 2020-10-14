package com.richie.leetcode.medium;

import java.util.*;

/**
 * @author Richie on 2020.10.14
 */
public class Medium_90 {
    /**
     * 子集 II
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/subsets-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,2,2]
     * 输出:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     * </p>
     *
     * <p>
     * 解答：回溯法
     * 先对数组排序，然后跳过重复元素，剩下的部分和 78题一样。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = new Medium_90().subsetsWithDup(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayDeque<>(), 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, Deque<Integer> path, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(result, nums, path, i + 1);
            path.removeLast();
        }
    }
}
