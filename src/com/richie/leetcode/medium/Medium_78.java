package com.richie.leetcode.medium;

import java.util.*;

/**
 * @author Richie on 2019.06.30
 */
public class Medium_78 {
    /**
     * 子集
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/subsets/
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
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     * </p>
     *
     * <p>
     * 解答：回溯
     * 把子集的求解看成一棵树，每个节点有选和不选两种状态，因为不允许重复元素，每次回溯时更新起始位置，过程中不需要剪枝。
     * </p>
     *
     * <p>
     * - 时间复杂度：O(n*logn)
     * - 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new Medium_78().subsets(nums);
        System.out.println(subsets);  // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayDeque<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, Deque<Integer> path, int[] nums, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start, len = nums.length; i < len; i++) {
            path.addLast(nums[i]);
            backtrack(result, path, nums, i + 1);
            path.removeLast();
        }
    }
}
