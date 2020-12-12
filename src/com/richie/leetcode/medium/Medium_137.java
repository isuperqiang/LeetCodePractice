package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.12.12
 */
public class Medium_137 {
    /**
     * 只出现一次的数字 II
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/single-number-ii/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [2,2,3,2]
     * 输出: 3
     * </p>
     *
     * <p>
     * 解答：位运算
     * 设计状态转换电路表示 3 种状态
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        int ans = new Medium_137().singleNumber(nums);
        System.out.println(ans);
    }

    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
