package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.11.21
 */
public class Easy_168 {
    /**
     * Excel表列名称
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/excel-sheet-column-title/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * 例如，
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     * ...
     * </p>
     *
     * <p>
     * 示例：
     * 输入: 28
     * 输出: "AB"
     * </p>
     *
     * <p>
     * 解答：
     * 本质上是 10进制转 26进制，因为低位不是从零开始，所以需要减一后再取模运算。
     * 和题目 171 相反。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * </p>
     */

    public static void main(String[] args) {
        String title = new Easy_168().convertToTitle(28);
        System.out.println(title); // AB
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n -= 1;
            sb.append((char) ('A' + (n % 26)));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
