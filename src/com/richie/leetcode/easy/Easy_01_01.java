package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.03.29
 */
public class Easy_01_01 {
    /**
     * 判定字符是否唯一
     * <p>
     * 链接：https://leetcode-cn.com/problems/is-unique-lcci/
     * </p>
     *
     * <p>
     * 描述：
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: s = "leetcode"
     * 输出: false
     * </p>
     *
     * <p>
     * 解答：
     * - 统计次数：使用一个额外的 int 数组，统计每个字符出现的次数。
     * - 位运算：int 类型有 32 位，取其中的低 26 位，作为每个字符的标志位，通过左移、与、或运算记录对应位置。
     * </p>
     *
     * <p>
     * 统计次数：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(N)
     * 位运算：
     * - 时间复杂度：O(N)
     * - 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        String s = "leetcode";
        boolean unique = isUnique2(s);
        System.out.println(unique); // false
    }

    private static boolean isUnique1(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        int[] counts = new int[26];
        for (int i = 0, length = astr.length(); i < length; i++) {
            int pos = astr.charAt(i) - 'a';
            if (counts[pos] >= 1) {
                return false;
            }
            counts[pos] += 1;
        }
        return true;
    }

    private static boolean isUnique2(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        int mark = 0;
        for (int i = 0, length = astr.length(); i < length; i++) {
            int flag = 1 << (astr.charAt(i) - 'a');
            if ((mark & flag) != 0) {
                return false;
            } else {
                mark |= flag;
            }
        }
        return true;
    }
}
