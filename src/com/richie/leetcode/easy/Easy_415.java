package com.richie.leetcode.easy;

/**
 * @author Richie on 2020.12.23
 */
public class Easy_415 {

    /**
     * 字符串相加
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/add-strings/
     * </p>
     *
     * <p>
     * 描述：
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * 提示：
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
     * </p>
     *
     * <p>
     * 示例：
     * "1" + "2" = "3"
     * </p>
     *
     * <p>
     * 解答：模拟加法
     * 定义两个指针 i j 分别指向两个字符串的末尾，定义 carry 维护当前是否有进位，从末尾到开头，逐位相加即可。
     * </p>
     *
     * <p>
     * 时间复杂度：O(max(M, N))
     * 空间复杂度：O(N)
     * </p>
     */

    public static void main(String[] args) {
        String ans = new Easy_415().addStrings("123", "456");
        System.out.println(ans);
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int ret = n1 + n2 + carry;
            sb.append(ret % 10);
            carry = ret / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
