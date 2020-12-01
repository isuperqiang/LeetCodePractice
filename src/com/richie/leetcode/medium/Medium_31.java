package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2020.09.16
 */
public class Medium_31 {
    /**
     * 下一个排列
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/next-permutation/
     * </p>
     *
     * <p>
     * 描述：
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须原地修改，只允许使用额外常数空间。
     * </p>
     *
     * <p>
     * 示例：
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * </p>
     *
     * <p>
     * 解答：
     * 1. 从后向前遍历数组查找第一个满足 n[i]<n[j] 的相邻元素 j=i+1，[j, end) 必然是降序排列。
     * 2. 从后向前遍历 [j, end) 子数组，查找第一个满足 n[k]>n[i] 的元素。
     * 3. 交换 n[i] 和 n[k]。
     * 4. 反转 [j, end) 子数组，使其降序变为升序。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 6, 5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // [1, 2, 3, 5, 4, 6]
    }

    private static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = nums.length - 1;
        if (i >= 0) {
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        int k = i + 1;
        int l = nums.length - 1;
        while (k < l) {
            swap(nums, k, l);
            k++;
            l--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
