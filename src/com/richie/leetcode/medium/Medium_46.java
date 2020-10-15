package com.richie.leetcode.medium;

import java.util.*;

/**
 * @author Richie on 2019.08.11
 */
public class Medium_46 {
    /**
     * 全排列
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/permutations/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * </p>
     *
     * <p>
     * 解答：回溯
     * 使用 visited 变量过滤相同元素，即剪枝。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n*n!)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Medium_46().permute(nums);
        System.out.println(permute);
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayDeque<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, Deque<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.addLast(nums[i]);
            backtrack(result, path, nums, visited);
            visited[i] = false;
            path.removeLast();
        }
    }
}
