package com.richie.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * @author Richie on 2020.09.23
 */
public class Medium_56 {
    /**
     * 合并区间
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/merge-intervals/
     * </p>
     *
     * <p>
     * 描述：
     * 给出一个区间的集合，请合并所有重叠的区间。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * </p>
     *
     * <p>
     * 解答：贪心算法
     * 1. 对所有的区间按照左端点进行排序，可以合并的区间一定是连续的，然后遍历集合。
     * 2. 如果当前区间的左端点大于结果集中最后一个区间的右端点，说明他们没有交集，把当前区间添加到结果集。
     * 3. 否则，说明他们有交集，从而进行合并操作，更新结果集最后区间的右端点，取两个区间右端点的最大值。
     * </p>
     *
     * <p>
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
        // [[1,6],[8,10],[15,18]]
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Deque<int[]> result = new ArrayDeque<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = result.getLast();
            if (current[0] > last[1]) {
                result.add(current);
            } else {
                last[1] = Math.max(last[1], current[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
