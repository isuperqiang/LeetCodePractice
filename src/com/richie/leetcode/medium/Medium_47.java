package com.richie.leetcode.medium;

import java.util.*;

/**
 * @author Richie on 2020.10.14
 */
public class Medium_47 {
    /**
     * 全排列 II
     * <p>
     * 链接：https://leetcode-cn.com/problems/permutations-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,1,2]
     * 输出:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     * </p>
     *
     * <p>
     * 解答：回溯
     * 首选对数组排序，然后和题目 46 一样通过回溯解决，注意增加了剪枝条件：当前元素和前一个元素相等并且前一个元素没有被使用过。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n*n!)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new Medium_47().permuteUnique(nums);
        System.out.println(lists);
        // [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayDeque<>(), new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, Deque<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.addLast(nums[i]);
            backtrack(result, nums, path, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
