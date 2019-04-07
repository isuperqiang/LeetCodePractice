package com.richie.leetcode.easy;

/**
 * @author richie on 2018.06.14
 */
public class Easy_8 {
    /**
     * 字符串转整数
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/string-to-integer-atoi/description/
     * </p>
     *
     * <p>
     * 描述：将字符串转为整数。
     * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
     * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
     * 若函数不能执行有效的转换，返回 0。
     * <p>
     * 说明：
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     * </p>
     *
     * <p>
     * 解答：首先处理边界条件，确定合法的开头，然后从头开始遍历查找数字，拼接到新的字符串，最后转换成整数。
     * </p>
     */

    public static void main(String[] args) {
        int i = myAtoi("-12");
        System.out.println(i);
        // 12
    }

    private static int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        str = str.trim();
        boolean signed = false;
        boolean negative = false;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            signed = true;
            if (str.length() == 1 || !Character.isDigit(str.charAt(1))) {
                return 0;
            }
            if (str.charAt(0) == '-') {
                negative = true;
            }
        } else if (!Character.isDigit(str.charAt(0))) {
            return 0;
        }

        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (signed) {
                if (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                    stringBuilder.append(chars[i + 1]);
                } else {
                    break;
                }
            } else {
                if (Character.isDigit(chars[i])) {
                    stringBuilder.append(chars[i]);
                } else {
                    break;
                }
            }
        }
        String posRet = stringBuilder.toString();
        int result;
        if (negative) {
            try {
                result = Integer.parseInt("-" + posRet);
            } catch (NumberFormatException e) {
                result = Integer.MIN_VALUE;
            }
        } else {
            try {
                result = Integer.parseInt(posRet);
            } catch (NumberFormatException e) {
                result = Integer.MAX_VALUE;
            }
        }
        return result;
    }

}
