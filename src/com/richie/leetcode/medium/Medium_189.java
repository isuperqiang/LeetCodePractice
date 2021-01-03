package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2018.05.30
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
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Medium_189().rotate3(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[length - 1];
            System.arraycopy(nums, 0, nums, 1, length - 1);
            nums[0] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        k %= length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[(i + k) % length] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, length);
    }

    public void rotate3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        k %= length;
        int count = 0;
        for (int i = 0; count < length; i++) {
            int currIdx = i;
            int currEle = nums[i];
            do {
                int nextIdx = (currIdx + k) % length;
                int nextEle = nums[nextIdx];
                nums[nextIdx] = currEle;
                currIdx = nextIdx;
                currEle = nextEle;
                count++;
            } while (i != currIdx);
        }
    }

    public void rotate4(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
