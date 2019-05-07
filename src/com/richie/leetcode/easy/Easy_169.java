package com.richie.leetcode.easy;

/**
 * @author richie on 2019.05.07
 */
public class Easy_169 {
    /**
     * 求众数
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/majority-element/
     * </p>
     *
     * <p>
     * 描述：给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * </p>
     *
     * <p>
     * 解答：从第一个数开始 count=1，遇到相同的就加 1，遇到不同的就减 1，如果减到 0，就换个数开始计数，总能找到最多的那个。
     * </p>
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement(nums);
        System.out.println(i); // 2
    }

    private static int majorityElement(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int count = 1;
        int major = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else {
                if (--count == 0) {
                    major = nums[i + 1];
                }
            }
        }
        return major;
    }
}
