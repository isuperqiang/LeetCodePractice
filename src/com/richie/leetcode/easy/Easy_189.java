package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author Richie on 2018.05.30
 */
public class Easy_189 {
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
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * </p>
     *
     * <p>
     * 说明：
     * - 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * - 要求使用空间复杂度为 O(1) 的原地算法。
     * </p>
     *
     * <p>
     * 解答：
     * - 暴力解法：循环 K 次，每次移动 1 个元素。
     * - 额外空间：使用额外数组保存旋转后的元素，把原来数组下标是 i 的元素放到临时数组 (i+k)%nums.length 的位置，然后写回原数组。
     * - 环状替换：计算每个元素的最终位置，每次迭代时替换到正确位置并保存被替换值，计算被替换值到正确位置。如果跳跃回到原地，就从下一个位置继续。
     * - 三次反转：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     * </p>
     *
     * <p>
     * 暴力解法：
     * - 时间复杂度：O(k*N)
     * - 空间复杂度：O(1)
     * 额外空间：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(N)
     * 环状替换：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(1)
     * 三次反转：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate4(a, k);
        System.out.println(Arrays.toString(a)); // [5, 6, 7, 1, 2, 3, 4]
    }

    private static void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[length - 1];
            for (int j = length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    private static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    private static void rotate3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int currentI = start;
            int currentE = nums[start];
            do {
                int nextI = (currentI + k) % nums.length;
                int temp = nums[nextI];
                nums[nextI] = currentE;
                currentE = temp;
                currentI = nextI;
                count++;
            } while (start != currentI);
        }
    }

    private static void rotate4(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
