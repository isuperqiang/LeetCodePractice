package com.richie.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Richie on 2019.06.20
 */
public class Easy_349 {
    /**
     * 两个数组的交集
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/
     * </p>
     *
     * <p>
     * 描述：给定两个数组，编写一个函数来计算它们的交集。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * </p>
     *
     * <p>
     * 说明：
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     * </p>
     * <p>
     * 解答：使用一个 Set 去除数组一重复元素，另一个 Set 保存两个数组的交集
     * </p>
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 3};
        int[] intersection = intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }

        Set<Integer> set1 = new HashSet<>(nums1.length);
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>(nums1.length);
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int size = set2.size();
        int[] ret = new int[size];
        Iterator<Integer> iterator = set2.iterator();
        for (int i = 0; i < size; i++) {
            ret[i] = iterator.next();
        }
        return ret;
    }

}
