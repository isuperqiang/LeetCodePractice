package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.11.21
 */
public class Easy_171 {
    /**
     * Excel表列序号
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     * 例如，
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * </p>
     *
     * <p>
     * 示例：
     * 输入: "AB"
     * 输出: 28
     * </p>
     *
     * <p>
     * 解答：
     * 把 26 个字母看作 26进制，遍历字符串，将每个字符减去 A，因为 A 表示 1，所以还要加上 1，得到当前字符代表的值，累加到结果中。
     * 和题目 168 相反。
     * </p>
     *
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int number = new Easy_171().titleToNumber("AB");
        System.out.println(number); // 28
    }

    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }
        int ans = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}
