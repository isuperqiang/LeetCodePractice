package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * 旋转数组
 *
 * @author Richie on 2020.12.02
 */
public class Medium_189 {
    // 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

    //    输入: [1,2,3,4,5,6,7] 和 k = 3
//    输出: [5,6,7,1,2,3,4]
//    解释:
//    向右旋转 1 步: [7,1,2,3,4,5,6]
//    向右旋转 2 步: [6,7,1,2,3,4,5]
//    向右旋转 3 步: [5,6,7,1,2,3,4]
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
