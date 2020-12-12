package com.richie.leetcode.medium;

/**
 * @author Richie on 2019.09.28
 */
public class Medium_334 {
    /**
     * 递增的三元子序列
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
     * 数学表达式如下:
     * 如果存在这样的 i, j, k,且满足 0 ≤ i < j < k ≤ n-1，
     * 使得 arr[i] < arr[j] < arr[k] ，返回 true ;否则返回 false 。
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,2,3,4,5]
     * 输出: true
     * 输入: [5,4,3,2,1]
     * 输出: false
     * </p>
     *
     * <p>
     * 解答：双指针
     * 定义 min 为序列中的较小值，mid 为中间值，看是否能找到较大值。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 1};
        boolean ans = new Medium_334().increasingTriplet(nums);
        System.out.println(ans);
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
