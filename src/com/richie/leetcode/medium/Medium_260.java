package com.richie.leetcode.medium;

import java.util.Arrays;

/**
 * @author Richie on 2020.12.12
 */
public class Medium_260 {
    /**
     * 只出现一次的数字 III
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/single-number-iii/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
     * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
     * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,2,1,3,2,5]
     * 输出: [3,5]
     * </p>
     *
     * <p>
     * 解答：位运算
     *
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] ans = new Medium_260().singleNumber(nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = xor & (-xor);
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
