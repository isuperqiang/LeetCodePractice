package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author Richie on 2020.03.20
 */
public class Easy_40 {
    /**
     * 最小的k个数
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * </p>
     *
     * <p>
     * 描述：
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * </p>
     *
     * <p>
     * 示例：
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * </p>
     *
     * <p>
     * 解答：
     *
     * </p>
     */

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int[] leastNumbers = getLeastNumbers(arr, 4);
        System.out.println("result: " + Arrays.toString(leastNumbers));
    }

    private static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }
        //        int[] result = new int[k];

        Arrays.sort(arr);
        int[] result = Arrays.copyOfRange(arr, 0, k);
        return result;
    }

}
