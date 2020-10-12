package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.05
 */
public class Easy_136 {
    /**
     * 只出现一次的数字
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/single-number/
     * </p>
     *
     * <p>
     * 描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [2,2,1]
     * 输出: 1
     * </p>
     *
     * <p>
     * 解答：
     * 异或运算的性质
     * - 一个数和 0 做 XOR 运算等于本身：a⊕0 = a
     * - 一个数和其本身做 XOR 运算等于 0：a⊕a = 0
     * - XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
     * 因此，数组中的全部元素的异或运算结果即为数组中只出现一次的数字。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {2, 2, 4, 4, 5};
        int i = new Easy_136().singleNumber(nums);
        System.out.println(i); // 5
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
