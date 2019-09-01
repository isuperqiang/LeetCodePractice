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
     * 地址：https://leetcode-cn.com/problems/3sum/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * </p>
     *
     * <p>
     * 示例：
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     * </p>
     *
     * <p>
     * 解答：
     * 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针 L 和 R 分别指向 nums[i] 后面的两端，
     * 计算三个数的和 sum，判断 sum 是否满足为 0。如果满足则添加进结果集，否则左右指针交替向中间移动。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = length - 1;
            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if (s == 0) {
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (s > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }

}
