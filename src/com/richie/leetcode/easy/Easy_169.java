package com.richie.leetcode.easy;

/**
 * @author richie on 2019.05.07
 */
public class Easy_169 {
    /**
     * 多数元素
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/majority-element/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * </p>
     *
     * <p>
     * 解答：
     * - 哈希表：使用哈希表记录每个元素出现的次数，遍历哈希表寻找 value 大于 nums.length/2 的 key。
     * - 排序法：将数组中的元素排序，中间元素总是多数元素。
     * - 摩尔投票算法：遇到相同的元素则票数 + 1，遇到不同的元素则票数 - 1。且“多数元素”的个数 > n/2，其余元素的个数总和 <= n/2。
     * 因此“多数元素”的个数 - 其余元素的个数总和的结果肯定 >= 1。相当于每个“多数元素”和其他元素两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     * </p>
     *
     * <p>
     * 摩尔投票算法：
     * - 时间复杂度：O(n)
     * - 空间复杂度：O(1)
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
            } else if (--count == 0) {
                major = nums[i];
                count = 1;
            }
        }
        return major;
    }
}
