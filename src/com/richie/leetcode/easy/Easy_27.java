package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author richie on 2019.04.07
 */
public class Easy_27 {
    /**
     * <p>
     * 地址：https://leetcode-cn.com/problems/remove-element/
     * </p>
     *
     * <p>
     * 描述：给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * </p>
     *
     * <p>
     * 解答：
     * - 解法一：题目要求原地修改，我想到的是在遍历数组的时候，如果当前元素和 val 相等，那么交换到后面的位置，最后的结果是
     * 要移除的元素都在数组右端，然后就得到新数组的长度和移除后的数组。
     * - 解法二：使用快慢指针，在遍历数组（快指针）的时候，如果当前元素和 val 不等，那么把元素赋值给慢指针，慢指针向后移动，
     * 最后根据慢指针的位置，就可以得到新的长度和移除后的数组。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 2;
        int length = removeElement1(nums, val);
        System.out.println("length: " + length + ", arrays: " + Arrays.toString(nums));
    }

    private static int removeElement1(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int valIndex = nums.length - 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == val & i <= valIndex) {
                int temp = nums[i];
                nums[i] = nums[valIndex];
                nums[valIndex--] = temp;
            } else {
                i++;
            }
        }
        return valIndex + 1;
    }

    private static int removeElement2(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int slowPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slowPointer++] = nums[i];
            }
        }
        return slowPointer;
    }

}
