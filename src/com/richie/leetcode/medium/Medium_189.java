package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2020.12.02
 */
public class Medium_189 {
    /**
     * 旋转数组
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/rotate-array/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * </p>
     *
     * <p>
     * 解答：环状替换
     * 移动 n 个元素需要交换 n 次，定义一个变量记录交换的次数。从头遍历数组，确定元素的新位置，和前一个元素交换。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Medium_189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        int len = nums.length;
        k %= len;
        int count = 0;
        for (int start = 0; count < len; start++) {
            int cur = start;
            int pre = nums[cur];
            do {
                int next = (cur + k) % len;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            } while (start != cur);
        }
    }
}
