package com.richie.leetcode.interview;

/**
 * @author Richie on 2020.03.29
 */
public class Interview_01_02 {
    /**
     * 判定是否互为字符重排
     * <p>
     * 链接：https://leetcode-cn.com/problems/check-permutation-lcci/
     * </p>
     *
     * <p>
     * 描述：
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * </p>
     *
     * <p>
     * 示例：
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     * </p>
     *
     * <p>
     * 解答：
     * 使用两个数组分别统计两个字符串中每个字符出现的次数，然后对比。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        boolean result = checkPermutation(s1, s2);
        System.out.println(result); // true
    }

    private static boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        for (int i = 0, length = s1.length(); i < length; i++) {
            int pos = s1.charAt(i) - 'a';
            count1[pos] += 1;
        }
        int[] count2 = new int[26];
        for (int i = 0, length = s2.length(); i < length; i++) {
            int pos = s2.charAt(i) - 'a';
            count2[pos] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

}
