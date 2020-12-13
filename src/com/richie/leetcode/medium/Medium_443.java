package com.richie.leetcode.medium;

/**
 * @author Richie on 2020.12.12
 */
public class Medium_443 {
    /**
     * 压缩字符串
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/string-compression/
     * </p>
     *
     * <p>
     * 描述：
     * 给定一组字符，使用原地算法将其压缩。压缩后的长度必须始终小于或等于原数组长度。
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。在完成原地修改输入数组后，返回数组的新长度。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：
     * ["a","a","b","b","c","c","c"]
     * 输出：
     * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
     * 说明：
     * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
     * </p>
     *
     * <p>
     * 解答：双指针
     * 定义左右指针指向数组开头，right 不断右移，如果出现值和 left 不等，把元素及其数量更新到数组，更新左指针的值为右指针。
     * </p>
     *
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int ans = new Medium_443().compress(chars);
        System.out.println(ans);
    }

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int size = 0;
        for (int right = 0, left = 0, len = chars.length; right <= len; right++) {
            if (right == len || chars[right] != chars[left]) {
                chars[size++] = chars[left];
                if (right - left > 1) { // right - 1 - left + 1 ==> right - left
                    char[] chs = String.valueOf(right - left).toCharArray();
                    for (char c : chs) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        return size;
    }
}
