package com.richie.leetcode.medium;

import java.util.*;

/**
 * @author Richie on 2020.09.20
 */
public class Medium_39 {
    /**
     * 组合总和
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/combination-sum/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个无重复元素的数组 candidates和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     * [7],
     * [2,2,3]
     * ]
     * </p>
     *
     * <p>
     * 解答：回溯
     * 本质上穷举所有结果是一棵树，我们采用 DFS 的方式遍历。组合意味着一组元素无序，即 [a, b] 和 [b, a] 看作相同解。所以在回溯的时候，注意起点的位置。
     * 回溯过程中，target 减去当前元素值，begin 不断向右移动。对数组排序有利于剪枝，减少算法的时间复杂度。
     * </p>
     *
     * <p>
     * 时间复杂度：
     * 空间复杂度：
     * </p>
     */
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> lists = combinationSum(candidates, 7);
        System.out.println(lists);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new LinkedList<>(), candidates, 0, target);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, Deque<Integer> path, int[] candidate, int begin, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidate.length; i++) {
            int diff = target - candidate[i];
            if (diff < 0) {
                break;
            }
            path.addLast(candidate[i]);
            backtrack(result, path, candidate, i, diff);
            path.removeLast();
        }
    }

}
