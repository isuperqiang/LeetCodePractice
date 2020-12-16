package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.12.16
 */
public class Medium_162 {
    /**
     * 寻找峰值
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/find-peak-element/
     * </p>
     *
     * <p>
     * 描述：
     * 峰值元素是指其值大于左右相邻值的元素。
     * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
     * <p>
     * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
     * 你可以假设 nums[-1] = nums[n] = -∞。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: nums = [1,2,3,1]
     * 输出: 2
     * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
     * </p>
     *
     * <p>
     * 解答：二分法
     * 如果 nums[i] < nums[i+1]，说明在上升阶段，因为 nums[n] 看作负无穷，最终一定会下降，所以 nums[i+1] 和 right 之间存在一个峰顶，抛弃左半部分。
     * 同理，num[i] > nums[i+1]，说明在下降阶段，因为 nums[-1] 看作负无穷，最初一定有上升，所以 left 和 nums[i] 之间存在一个峰顶，抛弃右半部分。
     * </p>
     *
     * <p>
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int ans = new Medium_162().findPeakElement(nums);
        System.out.println(ans);
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
