package com.richie.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author richie on 2019.04.07
 */
public class Easy_13 {
    /**
     * <p>
     * 地址：https://leetcode-cn.com/problems/roman-to-integer/
     * </p>
     *
     * <p>
     * 描述：给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * </p>
     *
     * <p>
     * 解答：把罗马数字和整数建立映射，然后从左到右遍历字符串，对比前后的两个值。因为正常的罗马数字是位上的值递减的，
     * 当出现左值大于右值，就使用两者的差作为结果。
     * </p>
     */

    public static void main(String[] args) {
        String roman = "IX";
        int romanInt = romanToInt(roman);
        System.out.println(roman + " is " + romanInt);
    }

    private static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> romanIntMap = new HashMap<>(8);
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);
        int result = 0;
        char[] chars = s.toCharArray();
        int preValue = 0;
        for (int i = 0; i < chars.length; i++) {
            int value = romanIntMap.get(chars[i]);
            if (value > preValue) {
                result -= preValue;
                result += value - preValue;
            } else {
                result += value;
            }
            preValue = value;
        }
        return result;
    }
}
