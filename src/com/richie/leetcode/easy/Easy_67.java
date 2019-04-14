package com.richie.leetcode.easy;

/**
 * @author richie on 2019.04.10
 */
public class Easy_67 {
    /**
     * 二进制求和
     *
     * <p>
     * 地址：https://leetcode-cn.com/problems/add-binary/
     * </p>
     *
     * <p>
     * 描述：给定两个二进制字符串，返回他们的和（用二进制表示）。输入为非空字符串且只包含数字 1 和 0。
     * </p>
     *
     * <p>
     * 解答：从低位开始每位相加，判断是否需要进位，对于长度不相等对字符串，短的左边看作 0。
     * </p>
     */

    public static void main(String[] args) {
        String a = "1011";
        String b = "1010";
        String s = addBinary2(a, b);
        System.out.println(s); // 10101
    }

    private static String addBinary1(String a, String b) {
        int aInt = Integer.valueOf(a, 2);
        int bInt = Integer.valueOf(b, 2);
        return Integer.toBinaryString(aInt + bInt);
    }

    private static String addBinary2(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        boolean aTinyb = aLen < bLen;
        boolean bTinya = aLen > bLen;
        int maxLen = aTinyb ? bLen : aLen;
        int diff = aTinyb ? bLen - aLen : aLen - bLen;
        int low = maxLen - 1;
        char sum;
        boolean prePlus = false;
        StringBuilder resultStr = new StringBuilder();
        while (low >= 0) {
            int aIndex;
            int bIndex;
            if (aTinyb) {
                aIndex = low - diff;
                bIndex = low;
            } else if (bTinya) {
                aIndex = low;
                bIndex = low - diff;
            } else {
                aIndex = low;
                bIndex = low;
            }
            char charA = '0';
            if (aIndex >= 0) {
                charA = a.charAt(aIndex);
            }
            char charB = '0';
            if (bIndex >= 0) {
                charB = b.charAt(bIndex);
            }
            boolean pre = prePlus;
            prePlus = false;
            if (charA == '1') {
                if (charB == '1') {
                    prePlus = true;
                    sum = '0';
                } else {
                    sum = '1';
                }
            } else {
                if (charB == '0') {
                    sum = '0';
                } else {
                    sum = '1';
                }
            }

            if (pre) {
                if (sum == '1') {
                    prePlus = true;
                    sum = '0';
                } else {
                    sum = '1';
                }
            }
            resultStr.append(sum);
            low--;
        }
        if (prePlus) {
            resultStr.append('1');
        }
        return resultStr.reverse().toString();
    }
}
