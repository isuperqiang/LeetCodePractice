package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.09.17
 */
public class Medium_33 {
    /**
     * 搜索旋转排序数组
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
     * </p>
     *
     * <p>
     * 描述：
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7]可能变为 [4,5,6,7,0,1,2])。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1。
     * 你可以假设数组中不存在重复的元素。
     * 你的算法时间复杂度必须是 O(logn) 级别
     * </p>
     *
     * <p>
     * 示例：
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * </p>
     *
     * <p>
     * 解答：二分查找
     * 分类讨论：
     * 1. 形如 4,5,6,7,0,1,2，nums[mid] >= nums[low]，即 7 > 4，此时前半部分严格有序，如果 nums[low]=<target<nums[mid]，
     * 则在前半部分查找，否则在后半部分查找。
     * 2. 形如 5,6,7,0,1,2,3，nums[mid] <= nums[high]，即 0 < 3，此时后半部分严格有序，如果 nums[mid]<target<=nums[high]，
     * 则在后半部分查找，否则在前半部分查找。
     * </p>
     *
     * <p>
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int index = search(nums, 0);
        System.out.println(index); // 4
    }

    private static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}
