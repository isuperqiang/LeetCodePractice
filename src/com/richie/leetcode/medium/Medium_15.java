package com.richie.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Richie on 2019.09.01
 */
public class Medium_15 {
    /**
     * 三数之和
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/3sum/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * </p>
     *
     * <p>
     * 示例：
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     * </p>
     *
     * <p>
     * 解答：排序+双指针
     * 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针 L 和 R 分别指向 nums[i] 后面的两端，
     * 计算三个数的和 sum，判断 sum 是否为 0。如果是则添加进结果集，否则左右指针交替向中间移动。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = new Medium_15().threeSum(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0, length = nums.length; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
