package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2020.09.20
 */
public class Medium_34 {
    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * </p>
     *
     * <p>
     * 解答：
     * 二分查找的变形：
     * - 查找左边界，找到目标值时不要退出，继续收缩右边界，向左边查找。退出循环后，检查左边界是否越界。
     * - 查找右边界，找到目标值时不要退出，继续收缩左边界，向右边查找。退出循环后，检查右边界是否越界。
     * </p>
     *
     * <p>
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * </p>
     */
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] range = searchRange(nums, 8);
        System.out.println(Arrays.toString(range)); // [3, 4]
    }

    private static int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }

}
