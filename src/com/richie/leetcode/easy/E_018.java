package com.richie.leetcode.easy;

import java.util.Arrays;
import java.util.Random;

/**
 * @author richie on 2018.06.22
 */
public class E_018 {
    /**
     * 打乱数组
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/shuffle-an-array/description/
     * </p>
     *
     * <p>
     * 描述：打乱一个没有重复元素的数组。
     * </p>
     *
     * <p>
     * 解答：先把原始的数组保存起来，然后打乱的时候，从当前节点之后的数字中随机选取一个，和当前节点做交换。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution(nums);
        for (int i = 0; i < 10; i++) {
            int[] shuffle = solution.shuffle();
            System.out.println("shuffle: " + Arrays.toString(shuffle));
        }
        int[] reset = solution.reset();
        System.out.println("reset: " + Arrays.toString(reset));
    }

    static class Solution {
        private int[] origin;

        public Solution(int[] nums) {
            origin = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return origin;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int length = origin.length;
            int[] cur = Arrays.copyOf(origin, length);

            Random random = new Random();
            for (int i = 0; i < length; i++) {
                int in = random.nextInt(length - i) + i;
                int temp = cur[i];
                cur[i] = cur[in];
                cur[in] = temp;
            }
            return cur;
        }
    }

}
