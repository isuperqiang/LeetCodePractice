package com.richie.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Richie on 2020.12.04
 */
public class Offer_61 {
    /**
     * 扑克牌中的顺子
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
     * 可以看成任意数字。A 不能视为 14。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: [1,2,3,4,5]
     * 输出: True
     * </p>
     *
     * <p>
     * 解答：
     * 使用集合 Set 去重，如果出现重复元素，直接返回 false。大小王 0 跳过，记录牌的最大和最小值，判断差是不是小于 5。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        boolean straight = new Offer_61().isStraight(nums);
        System.out.println(straight);
    }

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return max - min < 5;
    }
}
