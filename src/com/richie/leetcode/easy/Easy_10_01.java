package com.richie.leetcode.easy;

import java.util.Arrays;

/**
 * @author Richie on 2020.03.28
 */
public class Easy_10_01 {
    /**
     * 合并排序的数组
     *
     * <p>
     * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci/
     * </p>
     *
     * <p>
     * 描述：
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * </p>
     *
     * <p>
     * 示例：
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     * </p>
     *
     * <p>
     * 解答：
     * 双指针解法。从后向前遍历两个数组，比较两个指针指向的数值，然后把较大值放入数组 A 末端。
     * </p>
     *
     * <p>
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * </p>
     */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }

    private static void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int idx = m + n - 1;
        while (j >= 0) {
            if (i < 0 || B[j] >= A[i]) {
                A[idx--] = B[j--];
            } else {
                A[idx--] = A[i--];
            }
        }
    }

}
