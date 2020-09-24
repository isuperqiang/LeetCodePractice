package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2020.09.24
 */
public class Medium_75 {
    /**
     * 颜色分类
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/sort-colors/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * </p>
     *
     * <p>
     * 解答：
     * 规定区间 [0, zero) 的元素都是 0，[zero, i] 的元素都是 1，(two, n-1] 的元素都是 2，初始化时首尾两个区间都为空，
     * 从头开始遍历数组，更新循环变量，并交换两个元素的位置。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Medium_75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                i++;
                zero++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, two);
                two--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
