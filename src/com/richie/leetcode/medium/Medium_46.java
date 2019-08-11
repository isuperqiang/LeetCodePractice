package com.richie.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

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
     * 解答：
     * 回溯法。深度优先搜索（DFS）和交换元素，
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }

    private static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, result);
        return result;
    }

    private static void dfs(int curr, int[] nums, List<List<Integer>> result) {
        if (curr == nums.length - 1) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            result.add(res);
            return;
        }
        for (int i = curr; i < nums.length; i++) {
            swap(nums, i, curr);
            dfs(curr + 1, nums, result);
            swap(nums, i, curr);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
