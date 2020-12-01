package com.richie.leetcode.medium;

/**
 * @author Richie on 2019.07.13
 */
public class Medium_287 {
    /**
     * 寻找重复数
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/
     * </p>
     *
     * <p>
     * 描述：给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,3,4,2,2]
     * 输出: 2
     * </p>
     *
     * <p>
     * 说明：
     * - 不能更改原数组（假设数组是只读的）。
     * - 只能使用额外的 O(1) 的空间。
     * - 时间复杂度小于 O(n2) 。
     * - 数组中只有一个重复的数字，但它可能不止重复出现一次。
     * </p>
     *
     * <p>
     * 解答：
     * 数组元素在 [0, n] 之间，可以作为数组索引使用。先通过快慢指针找到相交点，然后两个指针分别从零位置和相交点一起向前遍历，直到找出相同的值。
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }

    private static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        slow = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

}
